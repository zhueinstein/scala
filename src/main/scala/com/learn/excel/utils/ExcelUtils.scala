package com.learn.excel.utils

import com.learn.excel.DrugExcelInfo
import info.folone.scala.poi.Workbook

import scalaz.{-\/, \/-}
import info.folone.scala.poi.{FormulaCell, NumericCell, Row, Sheet, StringCell, Workbook}
/**
  * 创建者： ZhuWeiFeng 
  * 日期： 2018/1/11
  */
class ExcelUtils[T] {
	def readExcel(localUrl:String)(fun: ((Sheet) => Unit))={
		val readResult = Workbook(localUrl)
			.map(workbook => workbook.sheets)
			.run
			.unsafePerformIO()
		readResult match {
			case -\/(exception) => throw new RuntimeException("Could not read file", exception)
			case \/-(sheets) => sheets.foreach(sheet => fun(sheet))
		}
	}

}

object ExcelUtils{
	def apply[T]: ExcelUtils[T] = new ExcelUtils()
}
