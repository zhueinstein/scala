package com.learn.addUnit

import com.learn.excel.MongoOperator
import com.mongodb.casbah.Imports._

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2017/12/25
  */
class AddUnit {
	def addUnit: Unit ={
		val client = MongoOperator.apply.mongoClient("audit_test")
		val db = client("drug_info")
		val coll = client("drug_info_20171225").find().toList
		val unitList = ReadUnit.apply.readExcel()
		for(drugInfo <- coll){
			val ex = unitList.find(unit => drugInfo.get("drugCode").equals(unit.drugCode))
			if(ex.isDefined){
				drugInfo += ("baseUnit" -> ex.get.unit)
				//				println(ds.get("drugCode"), ex.get.getUnit)
			}
			db.insert(drugInfo)
		}

	}

}

object AddUnit extends App{
	def apply: AddUnit = new AddUnit()
	AddUnit.apply.addUnit
}

