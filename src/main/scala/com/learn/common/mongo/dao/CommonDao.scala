package com.learn.common.mongo.dao

import java.text.SimpleDateFormat
import java.util.Date

import com.alibaba.fastjson.JSON
import com.google.gson.Gson
import com.learn.common.mongo.dto._
import com.mongodb.BasicDBObject
import com.mongodb.casbah.Imports._
import play.api.libs.json._

import scala.util.parsing.json.JSONObject
/**
  * 创建者： ZhuWeiFeng 
  * 日期： 2018/2/6
  */
object CommonDao {
	/**
	  *      获取MonoDb的连接
	  * @return
	  */
	def mongoClient: MongoClient ={
		val server = new ServerAddress("10.1.10.51", 27017)
		val credentials = MongoCredential.createCredential("wanhuaudit", "audit_test", Array.apply('1','2','3','4','5','6'))
		MongoClient(server, List(credentials))
	}
	val db = mongoClient("audit_test")

	object MyWriter {
		implicit val anyValWriter = Writes[Any] (a => a match {
			case v:String => Json.toJson(v)
			case v:Int => Json.toJson(v)
			case v:Any => Json.toJson(v.toString)
			// or, if you don't care about the value
			case _ => throw new RuntimeException("unserializeable type")
		})
	}
	def auditCase():List[AuditCase] = {
		db("audit_case").find(). map(ds => JSON.parseObject(ds.toString, classOf[AuditCase])).toList
	}

	def auditOrder(dsl: DBObject):List[AuditOrder] = {
		db("audit_order").find(dsl).map(ds => JSON.parseObject(ds.toString, classOf[AuditOrder])).toList
	}
	def auditResult(dsl: DBObject):List[Result] = {
		db("audit_result").find(dsl).map(ds => JSON.parseObject(ds.toString, classOf[Result])).toList
	}
	def drugInfo(dsl: DBObject):List[DrugInfo] = {
		db("drug_info_20171225").find(dsl).map(ds => JSON.parseObject(ds.toString, classOf[DrugInfo])).toList
	}
	def saveDrugInfo(drugInfos: List[DrugInfo])={
		val gson = new Gson()
		val dt = db("drug_info_20171225")
		val dbList = drugInfos.map(ds => BasicDBObject.parse(gson.toJson(ds)).asInstanceOf[DBObject])
		dbList.foreach(ds => dt.save(ds))
	}
	def main(args: Array[String]): Unit = {
		val dsl = ("caseId" $eq "5a44bfb1ed1c4e3fe7c1cf6a")
		val dsl2 = ("drugCode" $eq "00120001")
		val gson = new Gson()
		val date = new Date()
		val df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
		println(df.format(date))
		val drug = drugInfo(dsl2).take(1)
		drug.foreach(ds => println(gson.toJson(ds)))
//		val  drug2 = drug.map(drug => {drug.time = DATE(df.format(new Date()));drug.drugName= "卡博平"; drug})
//		drug2.foreach(ds => println(ds.time))
//		saveDrugInfo(drug2)

	}
}
