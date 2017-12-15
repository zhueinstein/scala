package com.learn.changshademo

import com.learn.excel._
import com.mongodb.casbah.Imports._
import play.api.libs.json.Json
import scalikejdbc.{AutoSession, ConnectionPool, _}
/**
  * 创建者： ZhuWeiFeng 
  * 日期：2017/12/8
  * 用途： 长沙药品数据导入mongo数据库
  */
class DrugInfoHandler {
	def queryFromDJWKDrugInfo(): Unit ={
		// 查询changshademo数据库
		Class.forName("com.mysql.jdbc.Driver")
		ConnectionPool.singleton("jdbc:mysql://10.1.10.51:3306/changsha_demo?characterEncoding=UTF-8&useSSL=true", "mysql", "123456")
		implicit val session = AutoSession

		val drugInfoList: List[DrugInfo] =
			sql"""
				select t.商品代号 as drugCode, t.通用名 as commonName, t.商品名 as productName, t.规格 as standard, t.厂家产地 as producer, t.万户通用名 as wanhuCommonName from drug_info t
				""".map(rs => DrugInfoFact(rs)).list().apply()
		println(drugInfoList.size)
		val db = MongoOperator.apply.mongoClient("audit_test")
		//val dsl = ("caseId" $eq caseId) ++ ("orderId" $in (in)) ++ ("resultType" $ne 3) ++ ("grade" $ne None) ++ ("drugScores" $ne None)
		val coll = db("drug_info")
		implicit val categoryFormat = Json.format[Category]
		implicit val IngredientFormat = Json.format[Ingredient]
		implicit val DiagnoseFormat = Json.format[Diagnose]
		implicit val drugInfoFormat = Json.format[DrugInfoForMongoChangSha]
		val drugs = coll.toList.map(di => Json.fromJson[DrugInfoForMongoChangSha](Json.parse(di.toString)).get)
		val preInt = 1000000000
		// 根据万户通用名匹配药品
		for( drugInfo <- drugInfoList){
			if(drugInfo.wanhuCommonName.isDefined){
				if(drugInfo.wanhuCommonName.isDefined){
					val mongoDB	= MongoDBObject.empty
					mongoDB += ("drugCode" -> (preInt + drugInfo.drugCode + ""))
					mongoDB += ("commonName" -> drugInfo.commonName)
					mongoDB += ("producer" -> (if(drugInfo.producer.isDefined) drugInfo.producer.get else null))
					if(drugInfo.standard.isDefined) {
						mongoDB += ("standard" -> drugInfo.standard.get)
					}
					if(drugInfo.productName.isDefined) {
						mongoDB += ("drugName" -> drugInfo.productName.get)
					}
					val changSha = drugs.filter(ds => ds.commonName.equals(drugInfo.wanhuCommonName.get)).filter(dd => dd.categorys.isDefined && dd.categorys.get.size > 0)
					if(changSha!= null && changSha.size > 0){
						if(changSha.head.applyDiagnose.isDefined){
							val list = MongoDBList.empty
							for(elem <- changSha.head.applyDiagnose.get){
								val mongoDBs = MongoDBObject.empty
								mongoDBs += ("diseaseName" -> elem.diseaseName)
								list += mongoDBs
							}
							mongoDB += ("applyDiagnose" -> list)
						}
						if(changSha.head.categorys.isDefined){
							val list = MongoDBList.empty
							for (elem <- changSha.head.categorys.get) {
								val mongoDBs = MongoDBObject.empty
								mongoDBs += ("layer" -> elem.layer)
								mongoDBs += ("categoryName" -> elem.categoryName)
								list += mongoDBs
							}
							mongoDB += ("categorys" -> list)
						}
						if(changSha.head.mainIngredients.isDefined){
							val list = MongoDBList.empty
							for (elem <- changSha.head.mainIngredients.get) {
								val mongoDBs = MongoDBObject.empty
								mongoDBs += ("ingredientId" -> elem.ingredientId)
								mongoDBs += ("ingredientName" -> elem.ingredientName)
								list += mongoDBs
							}
							mongoDB += ("mainIngredients" -> list)
						}
						coll.insert(mongoDB)
					}else{
						coll.insert(mongoDB)
					}
				}else{
					coll.insert(mongoDB)
				}
			}else{
				coll.insert(mongoDB)
			}
		}
	}
}
case class DrugInfoForMongoChangSha(commonName: String, categorys: Option[List[Category]], mainIngredients: Option[List[Ingredient]], applyDiagnose:Option[List[Diagnose]])
case class MongoDrugInfo(drugCode: String, drugName: String , commonName: String, standard: String,
						 producer:String, categorys: List[Category],mainIngredients: List[Ingredient]
						)
case class Diagnose(diseaseName: String)
case class DrugInfo(drugCode: Int, commonName: String, productName: Option[String], standard: Option[String], producer: Option[String], wanhuCommonName: Option[String])

object DrugInfoHandler extends App{
	def apply: DrugInfoHandler = new DrugInfoHandler()

	DrugInfoHandler.apply.queryFromDJWKDrugInfo()
}
object DrugInfoFact extends SQLSyntaxSupport[DrugInfo]{
	override val tableName = "drug_info"
	def apply(rs: WrappedResultSet) = new DrugInfo(
		rs.int("drugCode"),
		rs.string("commonName"),
		rs.stringOpt("productName"),
		rs.stringOpt("standard"),
		rs.stringOpt("producer"),
		rs.stringOpt("wanhuCommonName")
	)
}
