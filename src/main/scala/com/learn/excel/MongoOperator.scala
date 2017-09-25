package com.learn.excel

import com.learn.exportJson.OrderInfo
import com.mongodb.casbah.Imports
import com.mongodb.casbah.Imports._
import org.json4s._
import org.json4s.jackson.JsonMethods._
import play.api.libs.json._

/**
  * Created by zcx on 2017/9/13.
  */
class MongoOperator {

	def mongoClient: MongoClient ={
		val server = new ServerAddress("10.1.10.51", 27017)
		val credentials = MongoCredential.createCredential("wanhuaudit", "audit_test", Array.apply('1','2','3','4','5','6'))
		MongoClient(server, List(credentials))
	}
	def drugInfo():List[DBObject] = {

		val db = mongoClient("audit_test")
		val coll = db("drug_info_bak")

		implicit val categoryFormat = Json.format[Category]
		implicit val diseaseFormat = Json.format[Disease]
		implicit val IngredientFormat = Json.format[Ingredient]
		implicit val drugInfoFormat = Json.format[DrugInfo]


		coll.find().toList
	}
}

object MongoOperator extends App{
	def apply: MongoOperator = new MongoOperator()
	MongoOperator.apply.drugInfo()
}

case class DrugInfo(drugCode: Option[String], drugName: Option[String] ,usage: Option[String], number: Option[String], price: Option[String],dosage: Option[String], standard: Option[String],
					producer:Option[String], categorys: Option[List[Category]], applyDiagnose: Option[List[Disease]], mainIngredients: Option[List[Ingredient]],
					packageSize: Option[Int], maximumDose: Option[String], maximumDoseDaily: Option[String], commonName: Option[String], pharmacology: Option[Category])
case class Category(categoryName: Option[String], layer: Option[Int], categoryCode: Option[String])
case class Disease(diseaseCode: Option[String], diseaseName:Option[String]);
case class Ingredient(ingredientId: Option[String], ingredientName: Option[String])


