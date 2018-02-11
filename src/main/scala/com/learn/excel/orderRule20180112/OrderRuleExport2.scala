package com.learn.excel.orderRule20180112

import com.learn.excel.MongoOperator
import com.mongodb.casbah.Imports._

import scala.io.Source

/**
  * 创建者： ZhuWeiFeng 
  * 日期： 2018/1/15
  */
object OrderRuleExport2 {
	val mongoDb = MongoOperator.apply.mongoClient("audit_test")
	val db = mongoDb("audit_order")

	def getData()={
//		val lines = Source.fromFile("/Users/zcx/scalaExcelTest//caseIdvsorderno.txt").getLines()
//		val dsl = $and("caseId" -> "5a4b4ba138e805bfd2101bdc", "caseId" -> "5a4b4ba138e805bfd2101bdd")

//		println(db.find(dsl).toList.size)
	}

	def main(args: Array[String]): Unit = {
		val mdyRules = (1 to 20).map(ds => "MEDC_" + ds )
		mdyRules.foreach(println(_))
	}
}
