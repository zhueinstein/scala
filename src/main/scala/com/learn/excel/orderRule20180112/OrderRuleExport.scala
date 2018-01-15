package com.learn.excel.orderRule20180112
import com.learn.excel.MongoOperator
import com.mongodb.casbah.Imports._
import info.folone.scala.poi.{NumericCell, Row, Sheet, StringCell, Workbook}
import scala.io.Source

/**
  * 创建者： ZhuWeiFeng 
  * 日期： 2018/1/12
  */
object OrderRuleExport {

	def main(args: Array[String]): Unit = {
		implicit  val list = getOrders()
		implicit val tuple4:List[Tuple4[String,String,DBObject,DBObject]] = handler
		val orderRules: List[OrderRule] = formaterOrders
		val neRules = OrderRule(0,"","","",0,"","",0,"","",0,0,"") :: orderRules
		implicit val sss = neRules.toSet[OrderRule]
		writeExcel.safeToFile("/Users/zcx/scalaExcelTest/20180112_01.xls").fold(ex => throw ex, identity).unsafePerformIO()
	}

	val db = MongoOperator.apply.mongoClient("audit_test")
	val tb = db("audit_order")
	val resultTb = db("audit_result")
	def getOrders(): List[DBObject] ={
		val dsl = ("caseId" $in Array("5a0a5ef6568d984e445fb2d3","5a3b9bdefbaaa56453c36283"))
		val orders = tb.find(dsl)
		val orderIds = Source.fromFile("/Users/zcx/scalaExcelTest/导出数据订单号.txt").getLines().toList
		val ll = orders.filter(ds => orderIds.contains(ds.get("orderNo"))).toList
		println(ll.size)
		ll
	}

	def handler(implicit list: List[DBObject])={
		val r = """[0-9a-z]{24}""".r
		val tup3List = list.map(ds => Tuple3(ds.get("caseId").toString, r findFirstIn ds.get("_id").toString get, ds))
		val tup4List = tup3List.map(dd => {
			val dsl2 = ("caseId" $eq dd._1.toString) ++ ("orderId" $eq dd._2.toString )
			Tuple4(dd._1, dd._2, dd._3, resultTb.findOne(dsl2).get)
		})
//		println(tup4List)
		tup4List
	}
	def formaterOrders(implicit tuple4s: List[Tuple4[String,String,DBObject,DBObject]]):List[OrderRule]={
		var index = 0
		var orderRules = List.empty[OrderRule]
		tuple4s.foreach(tuple4 =>{

			val ruleLines = handleRules(tuple4._4)
			ruleLines match {
				case scala.collection.mutable.Seq(one, _*) => {
					 ruleLines.foreach(dsd => {
						 index += 1
						 ruleLines.indexOf(dsd) match {
							 case 0 =>{
								 orderRules = OrderRule(index, tuple4._3.get("hospital").asInstanceOf[DBObject].get("hospitalName").toString, tuple4._3.get("orderNo").toString,
										 tuple4._4.get("resultType").toString, BigDecimal(tuple4._4.get("grade").toString),
										 tuple4._3.get("doctor").toString, tuple4._3.get("patient").asInstanceOf[DBObject].get("name").toString,
										 tuple4._3.get("patient").asInstanceOf[DBObject].get("age").toString.toInt, if (tuple4._3.get("patient").asInstanceOf[DBObject].get("sex").toString.toInt == 0) "女" else "男",
										 if (tuple4._3.get("mainDiagnosis") != null) {
											 tuple4._3.get("mainDiagnosis").toString
										 } else {
											 ""
										 }, BigDecimal(tuple4._3.get("totalMoney").toString),
										 BigDecimal(tuple4._4.get("totalSave").toString), dsd) :: orderRules
							 }
							 case _ => {
								 orderRules = OrderRule(index, "", "", "", 0,  "", "", 0, "",  "", 0,  0, dsd) :: orderRules
							 }
						}
					})
				}
				case _ => {
					index += 1
					orderRules = OrderRule(index, tuple4._3.get("hospital").asInstanceOf[DBObject].get("hospitalName").toString, tuple4._3.get("orderNo").toString,
						tuple4._4.get("resultType").toString, BigDecimal(tuple4._4.get("grade").toString),
						tuple4._3.get("doctor").toString, tuple4._3.get("patient").asInstanceOf[DBObject].get("name").toString,
						tuple4._3.get("patient").asInstanceOf[DBObject].get("age").toString.toInt, if (tuple4._3.get("patient").asInstanceOf[DBObject].get("sex").toString.toInt == 0) "女" else "男",
						if (tuple4._3.get("mainDiagnosis") != null) {
							tuple4._3.get("mainDiagnosis").toString
						} else {
							""
						}, BigDecimal(tuple4._3.get("totalMoney").toString),
						BigDecimal(tuple4._4.get("totalSave").toString), "") :: orderRules
				}
			}
			/*if(ruleLines != null && ruleLines.size >0) {
				ruleLines.foreach(line => {
					index += 1
					if (ruleLines.indexOf(line) == 0) {
						orderRules = OrderRule(index, tuple4._3.get("hospital").asInstanceOf[DBObject].get("hospitalName").toString, tuple4._3.get("orderNo").toString,
							tuple4._4.get("resultType").toString, BigDecimal(tuple4._4.get("grade").toString),
							tuple4._3.get("doctor").toString, tuple4._3.get("patient").asInstanceOf[DBObject].get("name").toString,
							tuple4._3.get("patient").asInstanceOf[DBObject].get("age").toString.toInt, if (tuple4._3.get("patient").asInstanceOf[DBObject].get("sex").toString.toInt == 0) "女" else "男",
							if (tuple4._3.get("mainDiagnosis") != null) {
								tuple4._3.get("mainDiagnosis").toString
							} else {
								""
							}, BigDecimal(tuple4._3.get("totalMoney").toString),
							BigDecimal(tuple4._4.get("totalSave").toString), line) :: orderRules
					} else {
						orderRules = OrderRule(index, "", tuple4._3.get("orderNo").toString,
							tuple4._4.get("resultType").toString, BigDecimal(tuple4._4.get("grade").toString),
							tuple4._3.get("doctor").toString, tuple4._3.get("patient").asInstanceOf[DBObject].get("name").toString,
							tuple4._3.get("patient").asInstanceOf[DBObject].get("age").toString.toInt, if (tuple4._3.get("patient").asInstanceOf[DBObject].get("sex").toString.toInt == 0) "女" else "男",
							if (tuple4._3.get("mainDiagnosis") != null) {
								tuple4._3.get("mainDiagnosis").toString
							} else {
								""
							}, BigDecimal(tuple4._3.get("totalMoney").toString),
							BigDecimal(tuple4._4.get("totalSave").toString), line) :: orderRules
					}
				})
			}else{
				orderRules = OrderRule(index, tuple4._3.get("hospital").asInstanceOf[DBObject].get("hospitalName").toString, tuple4._3.get("orderNo").toString,
					tuple4._4.get("resultType").toString, BigDecimal(tuple4._4.get("grade").toString),
					tuple4._3.get("doctor").toString, tuple4._3.get("patient").asInstanceOf[DBObject].get("name").toString,
					tuple4._3.get("patient").asInstanceOf[DBObject].get("age").toString.toInt, if (tuple4._3.get("patient").asInstanceOf[DBObject].get("sex").toString.toInt == 0) "女" else "男",
					if (tuple4._3.get("mainDiagnosis") != null) {
						tuple4._3.get("mainDiagnosis").toString
					} else {
						""
					}, BigDecimal(tuple4._3.get("totalMoney").toString),
					BigDecimal(tuple4._4.get("totalSave").toString), "") :: orderRules
			}*/

		})
//		orderRules.foreach(ds => println(ds))
		orderRules
	}

	def handleRules(dBObject: DBObject):scala.collection.mutable.Seq[String]={
		var rules = scala.collection.mutable.Seq.empty[String];
		if(dBObject.get("automaticAuditResults") != null){
			val rule = dBObject.get("automaticAuditResults")
			rules = if(rule.isInstanceOf[MongoDBList]) {
					rule.asInstanceOf[MongoDBList].map(ds =>{
						ds.asInstanceOf[DBObject].get("ruleName").toString
					})
				}else{
				        rule.asInstanceOf[BasicDBList].map(dd =>{
						dd.asInstanceOf[DBObject].get("ruleName").toString
					})
				}
		}
		rules.distinct
	}
	def writeExcel(implicit list: Set[OrderRule])={
		Workbook {
			Set(Sheet("处方评分") {
				list.map(ep => {

					Row(ep.index) {
						ep.index match {
							case 0 => Set(StringCell(0, "机构"), StringCell(1, "订单号"), StringCell(2, "审核结果"), StringCell(3, "评分"), StringCell(4, "医生"),StringCell(5, "患者"), StringCell(6, "年龄"), StringCell(7, "性别"), StringCell(8, "疾病"), StringCell(9, "金额"), StringCell(10, "可结余金额"), StringCell(11, "违反规则"))
							case _ => Set(  if(ep.hospitalName == "") StringCell(0, "") else StringCell(0, ep.hospitalName),
								                if(ep.hospitalName == "") StringCell(1, "")else StringCell(1, ep.orderNo),
										if(ep.hospitalName == "") StringCell(2, "")else StringCell(2, if(ep.resultType=="1") "正常" else if(ep.resultType=="2") "可疑" else if(ep.resultType=="3") "违规" else ""),
										if(ep.hospitalName == "") StringCell(3, "") else StringCell(3, ep.score.toString()),
								                if(ep.hospitalName == "") StringCell(4, "")else StringCell(4, ep.doctorName),
										if(ep.hospitalName == "") StringCell(5, "")else StringCell(5, ep.patientName),
										if(ep.hospitalName == "") StringCell(6, "")else NumericCell(6, ep.patientAge),
										if(ep.hospitalName == "") StringCell(7, "")else StringCell(7, ep.patientSex),
										if(ep.hospitalName == "") StringCell(8, "")else StringCell(8, ep.diseaseNames),
										if(ep.hospitalName == "") StringCell(9, "")else NumericCell(9, ep.totalMoney.toDouble),
										if(ep.hospitalName == "") StringCell(10, "")else NumericCell(10, ep.savedMoney.toDouble),
										StringCell(11, ep.ruleName))
						}
					}
				})
			})
		}
	}
}
case class OrderInfo()
//机构	订单号	审核结果	评分	医生	患者	年龄	性别	疾病	金额	可结余金额	违反规则
case class OrderRule(index: Int, hospitalName: String, orderNo: String, resultType: String, score: BigDecimal, doctorName: String, patientName: String,
                    patientAge: Int, patientSex: String, diseaseNames: String, totalMoney: BigDecimal, savedMoney: BigDecimal, ruleName: String)
