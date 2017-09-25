package com.learn.pickData

import com.learn.excel.{MongoOperator, WriteExcel}
import com.mongodb.casbah.Imports._
import play.api.libs.json.{JsError, Json}

/**
  * Created by zcx on 2017/9/21.
  */
class PickData {
	def pickData(): Set[ExportData] ={
		val caseName = "芜湖2017年05月01日-2017年07月30日处方评分";
		val db = MongoOperator.apply.mongoClient("audit_test");
		println(db.collectionNames().mkString(" "))
		val collCase = db("audit_case")
		val caseId = collCase.findOne(DBObject("name" -> caseName)).get.get("_id").toString

		val collOrder = db("audit_order")
		val auditOrders = collOrder.find(DBObject("caseId" -> caseId)).toList
		val collResult = db("audit_result")

		val results = collResult.find(DBObject("caseId" -> caseId, "resultType" -> 1)).toList
		implicit val patientFormat = Json.format[Patient]
		implicit val diseaseFormat = Json.format[Disease]
		implicit val categoryFormat = Json.format[Category]
		implicit val ingredientFormat = Json.format[Ingredient]
		implicit val drugFormat = Json.format[Drug]
		implicit val orderFormat = Json.format[AuditOrder]
		val orderObjects = auditOrders.map(order => (Json.fromJson[AuditOrder](Json.parse(order.toString)).get))

		implicit val resultFormat = Json.format[Result]
		val resultObjects = results.map(result => Json.fromJson[Result](Json.parse(result.toString)).get)
		var set: scala.collection.mutable.Set[ExportData] = scala.collection.mutable.Set[ExportData](ExportData(0, "", "", 0, "", "", "", "", "",BigDecimal(1), "", "", ""))
		var number = 1
		orderObjects.foreach(order => {
			val result = resultObjects.find(result => result.orderId.equals(order._id.get("$oid").get))
			if(result.isDefined) {
				var index = 1
				order.drugs.foreach(drug => {

					set +=  ExportData(number, order.orderNo, order.patient.name, order.patient.age,
						if(order.patient.sex == 0) "男" else "女", drug.drugCode, drug.commonName.concat("(").concat(drug.drugName).concat(")"), drug.number, drug.usage,
						BigDecimal(result.get.drugScores.get(drug.drugCode).get), if(index == 1) result.get.grade else "", order.doctor, order.diseases.map(dis => dis.diseaseName).mkString(","))
					number += 1
					index += 1
				})
				index = 1
			}
		})
		set.toSet
	}
}

case class ExportData(number: Int, orderNo: String, patientName: String, age: Int, sex: String, drugCode: String, drugName: String, amount: String, usage: String, drugScore: BigDecimal, grade: String, doctorName: String, diseases: String)
object PickData extends App{
	def apply: PickData = new PickData()

	PickData.apply.pickData()
}


case class AuditOrder(_id: Map[String, String], orderNo: String, patient:Patient, diseases: List[Disease], drugs: List[Drug], doctor: String )

case class Patient(name: String, age: Int, sex: Int, idCard: String)
case class Disease(diseaseName: String)
case class Drug(drugCode: String, drugName: String, usage: String, number: String, price: String, dosage: String
, packageSize: Int,
maximumDose: String, maximumDoseDaily: String, commonName: String)
case class Category(categoryName: String)
case class Ingredient(ingredientName: String)
case class Result(caseId: String, orderId: String, grade: String, drugScores: Map[String, Int])