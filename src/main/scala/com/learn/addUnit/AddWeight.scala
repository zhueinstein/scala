package com.learn.addUnit

import com.learn.excel.MongoOperator
import com.mongodb.casbah.Imports._
/**
  * 创建者： ZhuWeiFeng 
  * 日期：2017/12/27
  */
class AddWeight(s: Int) {
	def add(): Unit ={
		val client = MongoOperator.apply.mongoClient("audit_test")
		val db = client("drug_info")
		val coll = client("drug_info_20171227").find().toList
		val r = """\d*\.?\d+[m,g,u,I]""".r
		val number = """\d*\.?\d+""".r
		coll.foreach(ds => {
			val sL: List[String] = r.findAllIn(ds.get("standard").toString).toList
			if(!sL.isEmpty && sL.size == 1) {
				println(number.findFirstIn(sL(0)) get)
				val weight = BigDecimal(number findFirstIn sL(0) get)
				ds += ("baseDosage" -> weight.toString())
			}
			db.insert(ds)
		})
	}
}

object AddWeight extends App{
	def apply(d: Int): AddWeight = new AddWeight(d)
//	AddWeight(1).add()
	val standard = "复方*30片/盒"
	val r = """\d*\.?\d+[m,g,u]""".r
	println(r findFirstIn standard )
}


