package com.learn.exportJson
import java.io.{File, PrintWriter}

import org.apache.commons.lang3.StringUtils
import org.joda.time._
import play.api.libs.json.Json
import scalikejdbc._

import scala.collection.mutable.{Map, Set}
import scala.math.BigDecimal.RoundingMode
/**
  * Created by zcx on 2017/9/20.
  */

class JdbcDataToJson{
	def queryFormMysql() = {
		Class.forName("com.mysql.jdbc.Driver")
		ConnectionPool.singleton("jdbc:mysql://10.1.10.51:3306/wanhu_sc0827_1?characterEncoding=UTF-8&useSSL=true", "mysql", "123456")

		implicit val session = AutoSession

		val orderInfoList: List[OrderInfo] =
			sql"""
			 SELECT  	oi.id,
			 			oi.order_no AS orderNo,
			 			oi.order_date AS orderDate,
			 			oi.patient_name AS patientName,
			 			case oi.patient_sex when '男'  then 0  else 1 end  AS sex ,
			             oi.patient_age AS age,
			             patient_id_card AS idCard,
			             oi.cycle,
			             oi.hospital_id AS hospitalId,
			             dh.name AS hospitalName,
			             bdi.product_code AS productCode,
			             dd.amount,
			             dd.use_amount AS useAmount,
			             dd.price,
			             dd.frequency,
			             doc.id AS doctorId,
			             doc.name AS doctorName,
		   				 (SELECT group_concat(dis.name)   FROM order_disease od LEFT JOIN disease_info dis ON od.disease_id = dis.id WHERE od.order_id = oi.id)  AS diseaseNames
 			 FROM order_info oi
			 LEFT JOIN doctor_hospital dh ON oi.hospital_id = dh.id
			 LEFT JOIN drug_detail dd ON dd.order_id = oi.id
			 INNER JOIN drug_info di ON di.id = dd.drug_id
			 INNER JOIN base_drug_info bdi ON bdi.id = di.base_drug_id
			 INNER JOIN doctor_info doc ON doc.id = oi.doctor_id
			 WHERE dh.city_id = '340200'  and oi.create_date BETWEEN '2017-05-01' AND '2017-07-30';
		   """.map(rs => OrderInfo(rs)).list.apply()
		// 订单药品合并
		var map: Map[String, OrderJsonObject] = Map()
		orderInfoList.foreach {
			orderInfo => {
				if (map.keySet.contains(orderInfo.orderNo)) {
					map.get(orderInfo.orderNo).get.drugs += DrugDetail(orderInfo.productCode, orderInfo.amount.intValue(), orderInfo.useAmount.intValue(), orderInfo.price, orderInfo.frequency)
				} else {

					var diseases: Set[Disease] = Set()
					if(orderInfo.diseaseNames != null ) orderInfo.diseaseNames.split(",").foreach { ddd => diseases += Disease(ddd) }

					map.put(orderInfo.orderNo, OrderJsonObject(orderInfo.orderNo,
						orderInfo.orderDate.toString("yyyy-MM-dd"),
						if(StringUtils.isNotBlank(orderInfo.doctorName)) orderInfo.doctorName else "默认",
						orderInfo.cycle,
						orderInfoList.filter(orderE => orderE.orderNo.equals(orderInfo.orderNo))
							.map(mm => (mm.amount * mm.price).setScale(2, RoundingMode.HALF_UP)).reduce((o1, o2) => (o1 + o2).setScale(2, RoundingMode.HALF_UP)),
						orderInfo.hospitalId,
						orderInfo.hospitalName,
						Patient(orderInfo.patientName,
						orderInfo.sex,
						if(orderInfo.age != null) orderInfo.age else 11,
						orderInfo.idCard),
						Set(DrugDetail(orderInfo.productCode, orderInfo.amount.intValue(), orderInfo.useAmount.intValue(), orderInfo.price, orderInfo.frequency)),
						diseases))

				}
			}
		}
		implicit val diseaseWrites = Json.writes[Disease]
		implicit val patientWrites = Json.writes[Patient]
		implicit val DrugDetailWrites = Json.writes[DrugDetail]
		implicit val residentWrites = Json.writes[OrderJsonObject]
		println(Json.toJson(map.values.toList))
		val writer = new PrintWriter(new File("/Users/zcx/scalaExcelTest/test_test.json" ))
		try {
			writer.write(Json.toJson(map.values.toList).toString())
		}finally {
			writer.close()
		}

	}
}
object JdbcDataToJson extends App{
	def apply: JdbcDataToJson = new JdbcDataToJson()
	JdbcDataToJson.apply.queryFormMysql()
}

case class OrderInfo(id: String, orderNo: String, orderDate: DateTime, patientName: String,
					 age: Int, sex: Int, idCard: String, cycle: Int, hospitalId: String, hospitalName: String,
					 productCode: String, amount: BigDecimal, useAmount: BigDecimal,price: BigDecimal, frequency:  String,
					 doctorId: String, doctorName: String, diseaseNames:String)

case class OrderJsonObject(orderNo: String, orderDate: String, doctor: String, cycle: Int, totalMoney: BigDecimal,
						   hospitalId: String, hospitalName: String, patient: Patient, drugs: Set[DrugDetail], diseases: Set[Disease])


object OrderInfo extends SQLSyntaxSupport[OrderInfo]{
	override val tableName = "order_info"
	def apply(rs: WrappedResultSet) = new OrderInfo(
		rs.string("id"),
		rs.string("orderNo"),
		rs.jodaDateTime("orderDate"),
		rs.string("patientName"),
		rs.int("age"),
		rs.int("sex"),
		rs.string("idCard"),
		rs.int("cycle"),
		rs.string("hospitalId"),
		rs.string("hospitalName"),
		rs.string("productCode"),
		rs.bigDecimal("amount"),
		rs.bigDecimal("useAmount"),
		rs.bigDecimal("price"),
		rs.string("frequency"),
		rs.string("doctorId"),
		rs.string("doctorName"),
		rs.string("diseaseNames")
	)
}

case class Hospital(hospitalId: String, hospitalName: String)

case class OrderDisease(orderId: String, diseaseId: String)

case class Disease(diseaseName: String)

case class  DrugDetail( drugCode: String, number: Int, dosage: Int, price: BigDecimal, usage: String )

case class Patient(name: String, sex: Int, age:Int, idCard: String)