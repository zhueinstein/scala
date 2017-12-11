package com.learn.excel

import com.learn.pickData.{ExportData, PickData}
import info.folone.scala.poi.{BooleanCell, FormulaCell, NumericCell, Row, Sheet, StringCell, Workbook}

/**
  * Created by zcx on 2017/9/13.
  * 用途： 生成excel文档
  */
class WriteExcel {
	def writer(data: Set[ExportData]): Workbook = {
		Workbook {
			Set(Sheet("处方评分") {
				data.map(ep => {

					Row(ep.number) {
						ep.number match {
							case 0 => Set(StringCell(0, "订单编号"), StringCell(1, "医生姓名"), StringCell(2, "患者姓名"), StringCell(3, "患者性别"), StringCell(4, "患者年龄"),StringCell(5, "诊断"),
								StringCell(6, "药品编码"), StringCell(7, "药品名称"), StringCell(8, "购买数量"), StringCell(9, "药品分级"),
								StringCell(10, "订单评分"), StringCell(11, "药品分数"))
							case _ => Set(StringCell(0, ep.orderNo), StringCell(1, ep.doctorName), StringCell(2, ep.patientName), StringCell(3, ep.sex),
								NumericCell(4, ep.age.toDouble),StringCell(5, ep.diseases),
								StringCell(6, ep.drugCode), StringCell(7, ep.drugName), NumericCell(8, ep.amount.toDouble),
								NumericCell(9, ((ep.drugScore /% (BigDecimal(3)) _1) + BigDecimal(1)).doubleValue()),
								if(!ep.grade.isEmpty) NumericCell(10, BigDecimal(ep.grade).doubleValue()) else StringCell(10, " "), NumericCell(11, ep.drugScore.doubleValue()))

						}
					}
				})

			})
		}
	}
}

object WriteExcel extends App{
	def apply: WriteExcel = new WriteExcel()
	val path = "/Users/zcx/scalaExcelTest/线上数据订单评分%s-%s.xls"
	var skip = 0
	val limit = 30000
	for(index <- 1 to 6){
		println("skip = " + skip)
		WriteExcel.apply.writer(PickData.apply.pickData(skip, limit)).safeToFile(String.format(path, skip.toString, (skip + limit).toString)).fold(ex => throw ex, identity).unsafePerformIO()
		skip = skip + limit;
	}
}
