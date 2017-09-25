package com.learn.excel
import play.api.libs.json._

/**
  * Created by zcx on 2017/9/14.
  */
object JsonExample extends App{
	import play.api.libs.json._
	implicit val deskFormat = Json.format[Desk]
	implicit val addressFormat = Json.format[Address]

	implicit val personFormat = Json.format[Person]


	//case class -> JSON object
	val person = Person("joymufeng", Option(List(Address(Option("JiangSu"), Option("NanJing")),Address(Option("JiangSu1"), Option("NanJing1")))), List(Desk("123")) )
	val json = Json.toJson[Person](person)
	println(json)
	val  sss =
		"""
		  {"name":"joymufeng","emails":[{"provinces":"麝香保心丸","city":"NanJing"},{"province":"JiangSu1","city":"NanJing1"}],"desks":[{"longs": "12"}], "nnn":"123"}
		""".stripMargin
	//JSON object -> case class
		val p1 = Json.fromJson[Person](Json.parse(sss)).get
		val p2 = json.as[Person]
		val p3 = json.asOpt[Person].get
		println(p1.desks.mkString(","))
	val str =
		"""
		  {"drugCode":"01090002","drugName":"11","commonName":"麝香保心丸","applyDiagnose":[{"diseaseName":"心绞痛"},{"diseaseName":"心肌梗死"},{"diseaseName":"冠心病"}],"mainIngredients":[{"ingredientName":"人工麝香"},{"ingredientName":"人参提取物"},{"ingredientName":"人工牛黄"},{"ingredientName":"肉桂"},{"ingredientName":"苏合香"},{"ingredientName":"蟾酥"},{"ingredientName":"冰片"}],"categorys":[{"categoryName":"中成药","layer":1},{"categoryName":"心脑血管系统","layer":2}],"packageSize":60,"maximumDose":2,"maximumDoseDaily":6,"pharmacology":{"categoryName":"111"},"standard":"22.5mg*60丸/盒","producer":"上海和黄药业有限公司"}
		""".stripMargin

	implicit val categoryFormat = Json.format[Category]
	implicit val diseaseFormat = Json.format[Disease]
	implicit val IngredientFormat = Json.format[Ingredient]
	implicit val drugInfoFormat = Json.format[DrugInfo]

	val or1 = Json.fromJson[DrugInfo](Json.parse(str)) match {
		case j:JsError => println(j)
			case _ => println(11)
	}

}

case class Person(name: String, emails: Option[List[Address]], desks: List[Desk])
case class Desk(longs: String)
case class Address(province: Option[String], city: Option[String])
