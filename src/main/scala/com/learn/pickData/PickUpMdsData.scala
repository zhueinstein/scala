package com.learn.pickData

import com.learn.excel.MongoOperator
import com.mongodb.casbah.Imports._
import play.api.libs.json.Json
import sun.jvm.hotspot.HelloWorld

import scala.collection.mutable.Set
/**
  * Created by zcx on 2017/9/26.
  */
object PickUpMdsData extends App{
	def apply: PickUpMdsData = new PickUpMdsData()

	println(PickUpMdsData.apply.values()._1.size)
	println(PickUpMdsData.apply.values()._2.size)
}
class PickUpMdsData {
	def values(): (scala.collection.immutable.Set[ExcelEntity], scala.collection.immutable.Set[ExcelEntity]) ={

		val caseName = "美德医150";
		val db = MongoOperator.apply.mongoClient("audit_test");
		println(db.collectionNames().mkString(" "))
		val collCase = db("audit_case")
		val caseId = collCase.findOne(DBObject("name" -> caseName)).get.get("_id").toString

		val collOrder = db("audit_order")
		val auditOrders = collOrder.find(DBObject("caseId" -> caseId)).toList
		val collResult = db("audit_result")
		val results = collResult.find(DBObject("caseId" -> caseId)).toList
		val normalResults = results.filter(dbo => dbo.get("resultType") == 1)
		val formalResults = results.filter(dbo => dbo.get("resultType") == 3)
		implicit val patientFormat = Json.format[Patient]
		implicit val diseaseFormat = Json.format[Disease]
		implicit val categoryFormat = Json.format[Category]
		implicit val ingredientFormat = Json.format[Ingredient]
		implicit val drugFormat = Json.format[Drug]
		implicit val orderFormat = Json.format[AuditOrder]
		val orderObjects = auditOrders.map(order => (Json.fromJson[AuditOrder](Json.parse(order.toString)).get))

		implicit val normalResultFormat = Json.format[Result]
		val normalResultObjects = normalResults.map(result => Json.fromJson[Result](Json.parse(result.toString)).get)
		implicit val ruleResultFormat = Json.format[RuleResult]
		implicit val formalResultFormat = Json.format[FormalResult]
		val formalResultObjects = formalResults.map(result => Json.fromJson[FormalResult](Json.parse(result.toString)).get)

		val normal1000 = normalResultObjects.take(1000)
		var norTop1000 = Set[ExcelEntity](ExcelEntity(0,"","","","",0,"","","","","","","","","", 0, "","","",""))
		var index = 1
		normal1000.foreach(nm => {
			val order = orderObjects.find(order => nm.orderId.equals(order._id.get("$oid").get)).get
			order.drugs.foreach(drug => {
				norTop1000 += ExcelEntity(index,order.orderNo, order.doctor, order.patient.name, if (order.patient.sex == 1) "女" else "男", order.patient.age, order.diseases.map(ds => ds.diseaseName).mkString(", "),
				drug.drugCode, drug.commonName, drug.drugName, drug.number, drug.dosage, drug.usage, drug.standard,drug.producer,drug.packageSize, "","","","")
				index += 1
			})
		})
		var groupMap: Map[String, List[FormalResult]] = Map[String, List[FormalResult]]()
		formalResultObjects.foreach(formal => {
			 val key = formal.automaticAuditResults.map(rule => rule.ruleId).mkString(",")
			 groupMap.get(key) match {
				 case Some(ruleId) =>  groupMap += (key -> ruleId.:+(formal))
				 case None => groupMap += (key -> List(formal))
			 }
		})

		var forTop1000 = Set[ExcelEntity](ExcelEntity(0,"","","","",0,"","","","","","","","","", 0,"","", "",""))
		index = 0

		val mdyRules = (1 to 20).map(ds => "MEDC_" + ds ).toList
		groupMap.foreach(gg =>{
			val top12 = gg._2.take(12)
			top12.foreach(top => {
				val order = orderObjects.find(oO => oO._id.get("$oid").get.equals(top.orderId)).get
				order.drugs.foreach(drug => {
					println(gg._2(0).automaticAuditResults.filter(dd => dd.resultType == 2).filter(de => !mdyRules.contains(de.ruleId)).filter(df => df.drugs.contains(drug.drugCode)).map(ds => ds.description).mkString(";:"))
					forTop1000 += ExcelEntity(index, order.orderNo, order.doctor, order.patient.name, if (order.patient.sex == 1) "女" else "男", order.patient.age, order.diseases.map(ds => ds.diseaseName).mkString(", "),
						drug.drugCode, drug.commonName, drug.drugName, drug.number, drug.dosage, drug.usage, drug.standard, drug.producer, drug.packageSize,
						gg._2(0).automaticAuditResults.filter(dd => dd.resultType == 3).filter(de => !mdyRules.contains(de.ruleId)).filter(df => df.drugs.contains(drug.drugCode)).map(ds => ds.description).mkString(";:"),
						gg._2(0).automaticAuditResults.filter(dd => dd.resultType == 2).filter(de => !mdyRules.contains(de.ruleId)).filter(df => df.drugs.contains(drug.drugCode)).map(ds => ds.description).mkString(";:"),
						gg._2(0).automaticAuditResults.filter(dd => dd.resultType == 3).filter(de => mdyRules.contains(de.ruleId)).filter(df => df.drugs.contains(drug.drugCode)).map(ds => ds.description).mkString(";:"),
						gg._2(0).automaticAuditResults.filter(dd => dd.resultType == 2).filter(de => mdyRules.contains(de.ruleId)).filter(df => df.drugs.contains(drug.drugCode)).map(ds => ds.description).mkString(";:")
					)
					index += 1
				})
			})
		})
		forTop1000.foreach(dd => println(dd.dubiousWHRules))
		Tuple2(norTop1000.toSet, forTop1000.toSet)
	}

}

case class FormalResult(caseId: String, orderId: String, automaticAuditResults: List[RuleResult])
case class RuleResult(ruleId: String, description:String, drugs:List[String], resultType: Int)




case class ExcelEntity(number: Int, orderNo: String,  doctorName: String, patientName: String, patientSex: String, patientAge: Int,
					  orderDiseases: String, drugCode: String, commonName: String, productName: String, buyAmount: String,
                                          useAmount: String, frequency: String, standard: String, producer: String, packageSize: Int,
                                          violateWHRules: String, dubiousWHRules: String, violateMDYRules: String,dubiousMDYRules: String)
