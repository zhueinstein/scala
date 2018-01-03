package com.learn.medImpact.orderdata

import com.learn.excel.MongoOperator
import com.mongodb.casbah.Imports._
import play.api.libs.json._

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2018/1/3
  */
class OrderExport100 {

	def export()={
		val mongo = MongoOperator.apply.mongoClient("audit_test")
		mongo("audit_order").find()
	}
}
