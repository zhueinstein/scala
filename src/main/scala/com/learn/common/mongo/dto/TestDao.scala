package com.learn.common.mongo.dto

import com.alibaba.fastjson.JSON
import play.api.libs.json._

/**
  * 创建者： ZhuWeiFeng 
  * 日期： 2018/2/7
  */
case class Book (author: String, content: String, id: String, time: Long, title: String)
case class Json23(name: String, status0: Int,status1: Int,status2: Int,status3: Int,status4: Int,status5: Int,status6: Int,status7: Int,status8: Int,status9: Int,
                  status10: Int,status11: Int,status12: Int,status13: Int,status14: Int,status15: Int,status16: Int,status17: Int,status18: Int,status19: Int,
                  status20: Int,status21: Int,status22: Int)

object TestDao extends App{
	val json = "{\"author\":\"hll\",\"content\":\"ES即etamsports\",\"id\":\"693\",\"time\":1490165237200,\"title\":\"百度百科\"}"
	val book: Book = JSON.parseObject(json, classOf[Book])
	println(book.author)
	val json23 = """{"name":"本地测试23","status0":10,"status1":10,"status2":10,"status3":10,"status4":10,"status5":10,"status6":10,"status7":10,"status8":10,"status9":10,"status10":10,"status11":10,"status12":10,"status13":10,"status14":10,"status15":10,"status16":10,"status16":10,"status16":10,"status17":10,"status18":10,"status1":10,"status20":10,"status21":10,"status22":10,}"""

	val js23: Json23 = JSON.parseObject(json23, classOf[Json23])
	println(js23.name)

//	implicit val json23Implicate = Json.fromJson(Json23)
//	val js232 = Json.fromJson[Json23](Json.parse(json23)).get
//	println(js232.name)
	val order = """{"_id":{"$oid":"5a0a5ef9568d984e07de5d0a"},"_class":"com.wanhuaudit.entity.AuditOrder","caseId":"5a0a5ef6568d984e445fb2d3","orderNo":"101011710190060","patient":{"name":"薛平兰","age":57,"sex":0,"idCard":"340211196006130048","isChronicDiseaseCard":0,"insurances":[{"insuranceName":"城镇职工医疗保险"}]},"diseases":[{"diseaseCode":"高血压","diseaseName":"高血压"}],"mainDiagnosis":"高血压 ","drugs":[{"drugCode":"00130001","drugName":"拜阿司匹灵","usage":"3","number":"5","price":"15.51","dosage":"1","standard":"100mg*30片/盒","producer":"拜耳医药保健有限公司","categorys":[{"categoryCode":"西药","categoryName":"西药","layer":1},{"categoryCode":"心脑血管系统","categoryName":"心脑血管系统","layer":2},{"categoryCode":"抑制血小板聚集","categoryName":"抑制血小板聚集","layer":3},{"categoryCode":"抑制血小板花生四烯酸代谢","categoryName":"抑制血小板花生四烯酸代谢","layer":4},{"categoryCode":"环氧化酶抑制剂","categoryName":"环氧化酶抑制剂","layer":5}],"mainIngredients":[{"ingredientId":"阿司匹林","ingredientName":"阿司匹林"}],"packageSize":30,"maximumDose":"1.0","maximumDoseDaily":"3.0","commonName":"阿司匹林肠溶片","pharmacology":{"categoryName":"抗血小板药"},"conversionRatio":30,"dosageForms":"片","approvalNumber":"国药准字J20130078","state":"正常","whScale":"0.15","supplement":"正式","recommendDosage":"75-100mg/d","monthUsage":"1.00","monthTreatmentExpense":"15.51","clinicalGuideline":1,"medicalInsuranceCategory":"乙类","originatorProduct":"是","effectType":"常释","medicineConvenience":"≥3次/日","marketShare":"0.78","quotedCompany":"是","scoreSummary":"18.00","scoreRecommendGuide":"10.00","scoreMedicalInsurance":"2.00","scoreOriginatorProduct":"2.00","scoreEffectType":"1.00","scoreMedicineConvenience":"1.00","scoreMarketRate":"1","scoreMarketShare":"2.00","scoreQuotedCompany":"1.00"},{"drugCode":"00230004","drugName":"波啡克","usage":"3","number":"10","price":"10.39","dosage":"1","standard":"5mg*10片/瓶","producer":"常州四药制药有限公司","categorys":[{"categoryCode":"西药","categoryName":"西药","layer":1},{"categoryCode":"心脑血管系统","categoryName":"心脑血管系统","layer":2},{"categoryCode":"降压类","categoryName":"降压类","layer":3},{"categoryCode":"钙通道阻滞剂","categoryName":"钙通道阻滞剂","layer":4},{"categoryCode":"钙通道选择性阻滞药","categoryName":"钙通道选择性阻滞药","layer":5},{"categoryCode":"二氢吡啶类","categoryName":"二氢吡啶类","layer":6}],"applyDiagnose":[{"diseaseName":"高血压"},{"diseaseName":"冠心病"},{"diseaseName":"心绞痛"}],"mainIngredients":[{"ingredientId":"非洛地平","ingredientName":"非洛地平"}],"packageSize":10,"maximumDose":"2.0","maximumDoseDaily":"2.0","commonName":"非洛地平缓释片","pharmacology":{"categoryName":"钙通道阻滞剂"},"containsOriginatorProductProportion":"是","conversionRatio":10,"dosageForms":"片","approvalNumber":"国药准字H20103138","state":"正常","whScale":"0.15","supplement":"正式","recommendDosage":"0.0","monthUsage":"3.00","monthTreatmentExpense":"37.02","originatorProductGenericDrugCostGap":"0.3820","clinicalGuideline":1,"medicalInsuranceCategory":"乙类","originatorProduct":"否","effectType":"缓释或控释","medicineConvenience":"1次/日","quotedCompany":"非","scoreSummary":"18.18","scoreRecommendGuide":"10.00","scoreMedicalInsurance":"2.00","scoreOriginatorProduct":"0.00","scoreEffectType":"2.00","scoreMedicineConvenience":"3.00","scoreMarketRate":"0","scoreMarketShare":"1.00","scoreQuotedCompany":"0.00","scoreTreatmentExpense":"1.18"}],"orderDate":{"$date":"2017-10-18T16:00:00.000Z"},"cycle":30,"doctor":"周伟","hospital":{"hospialId":"d3d85da4d2c44769a54958b5233b13fa","hospitalName":"弋江区南瑞社区卫生服务中心"},"status":99,"resultType":3,"totalMoney":"181.45","updateDate":{"$date":"2017-11-14T03:20:39.739Z"},"flags":0}"""
	val orderEntity: AuditOrder = JSON.parseObject(order, classOf[AuditOrder])
	println(orderEntity._class)
}
