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
  *  用途： 导出数据库数据，用于审核系统的json文件
  */

class JdbcDataToJson{
	def queryFormMysql() = {
		Class.forName("com.mysql.jdbc.Driver")
		ConnectionPool.singleton("jdbc:mysql://10.1.10.51:3306/wanhu_sc1020_1?characterEncoding=UTF-8&useSSL=true", "mysql", "123456")

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
			 WHERE dh.city_id = '340200'  and oi.create_date BETWEEN '2017-05-01' AND '2017-07-30'
			   AND oi.order_no in ('101011705030460','101011705080230','101011705110480','101011705160200','101011705200060','101011705220280','101011705240270','101011705250400','101011705290430','101011706090350','101011706120390','101011706130220','101011706180050','101011706220310','101011706250060','101011706250180','101011706290270','101011706300290','101011707040100','101011707150070','101011707180280','101011707190170','101011707260360','101101706190070','101111705230190','101111705230200','101111706060050','101111706210110','101181706130010','101181707010010','101181707170030','101181707180100','101251705090030','101251706110020','101251706250060','101251707090200','101251707100130','101251707100150','101251707180040','101271705310050','101281705170040','101281705260010','101281706160020','101281707140050','102061705050020','102131706040010','102221705100100','102221706280090','102231707170020','102251705190060','102251705230230','102251705240080','102251706020110','102251706260060','102251706260390','102251706280170','102251706290120','102251707030140','102251707060200','102251707120190','102251707130170','102251707240220','102901705020130','102901705220290','102901706020100','102901706050290','102901706050300','102901706070310','102901706190120','102901706210090','102901706230020','102901707060080','102901707060170','102901707240050','102901707260090','102901707270200','102921705090020','102921707120040','102941705020030','102941707090040','102941707120440','102961705030380','102961705150460','102961705190070','102961705310170','102961706050330','102961706060390','102961706080110','102961706080350','102961706130140','102961706190400','102961706280060','102961707110170','102961707170250','102961707270200','102971706190280','102971707030220','102991705220040','102991706070060','103191705020030','103191707030080','103191707120050','103201707240040','103321706050070','103361707250010','103601706120130','103691706230010','103891706050260','103891706140080','103941706070030','103981707250010','103991706260060','104291706070020','104401705120040','104401706080070','104411706190030','104421705040030','104491705170010','104491707060060','104811705250030','104831705190030','104871706210020','104881706220030','104911706050050','104941707150010','105041706160010');
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
		val writer = new PrintWriter(new File("/Users/zcx/scalaExcelTest/test_20171227.json" ))
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