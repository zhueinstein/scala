package com.learn.excel

import com.learn.pickData.{ExcelEntity, PickUpMdsData}
import info.folone.scala.poi.{NumericCell, Row, Sheet, StringCell, Workbook}

/**
  * Created by zcx on 2017/9/26.
  */
class WriteMdsExcel {
	def writer(data: (Set[ExcelEntity], Set[ExcelEntity])): Workbook = {
		Workbook {
			Set(Sheet("正常处方") {
				data._1.map(ep => {

					Row(ep.number) {
						ep.number match {
							case 0 => Set(StringCell(0, "订单编号"), StringCell(1, "医生姓名"), StringCell(2, "患者姓名"), StringCell(3, "患者性别"), StringCell(4, "患者年龄"),StringCell(5, "诊断"),
								StringCell(6, "药品编码"), StringCell(7, "通用名"),StringCell(8,"药品名称"), StringCell(9, "购买数量"), StringCell(10, "频次"),
								StringCell(11, "单次使用量"), StringCell(12, "产品规格"), StringCell(13, "生产厂家"), StringCell(14, "规格大小"))
							case _ => Set(StringCell(0, ep.orderNo), StringCell(1, ep.doctorName), StringCell(2, ep.patientName), StringCell(3, ep.patientSex),
								NumericCell(4, ep.patientAge.toDouble),StringCell(5, ep.orderDiseases),
								StringCell(6, ep.drugCode), StringCell(7, ep.commonName),StringCell(8, ep.productName), NumericCell(9, ep.buyAmount.toDouble),
								NumericCell(10, ep.frequency.toDouble), NumericCell(11, ep.useAmount.toDouble), StringCell(12, ep.standard),StringCell(13, ep.producer), NumericCell(14, ep.packageSize))
						}
					}
				})

			},Sheet("违规处方") {
					data._2.map(ep => {

						Row(ep.number) {
							ep.number match {
								case 0 => Set(StringCell(0, "订单编号"), StringCell(1, "医生姓名"), StringCell(2, "患者姓名"), StringCell(3, "患者性别"), StringCell(4, "患者年龄"),StringCell(5, "诊断"),
									StringCell(6, "药品编码"), StringCell(7, "通用名"),StringCell(8,"药品名称"), StringCell(9, "购买数量"), StringCell(10, "频次"),
									StringCell(11, "单次使用量"), StringCell(12, "规格"), StringCell(13, "生产厂家"), StringCell(14, "规格大小"), StringCell(15, "违反规则"))
								case _ => Set(StringCell(0, ep.orderNo), StringCell(1, ep.doctorName), StringCell(2, ep.patientName), StringCell(3, ep.patientSex),
									NumericCell(4, ep.patientAge.toDouble),StringCell(5, ep.orderDiseases),
									StringCell(6, ep.drugCode), StringCell(7, ep.commonName),StringCell(8, ep.productName), NumericCell(9, ep.buyAmount.toDouble),
									NumericCell(10, ep.frequency.toDouble), NumericCell(11, ep.useAmount.toDouble), StringCell(12, ep.standard),StringCell(13, ep.producer), NumericCell(14, ep.packageSize), StringCell(15, ep.rules))
							}
						}
					})

				})


		}
	}
}

object WriteMdsExcel extends App{
	val path = "/Users/zcx/scalaExcelTest/mdy1.xls";
	def apply: WriteMdsExcel = new WriteMdsExcel()
	WriteMdsExcel.apply.writer(PickUpMdsData.apply.values()).safeToFile(path).fold(ex => throw ex, identity).unsafePerformIO()
}
