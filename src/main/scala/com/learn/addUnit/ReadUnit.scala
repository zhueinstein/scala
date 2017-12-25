package com.learn.addUnit

import info.folone.scala.poi.{FormulaCell, NumericCell, Row, Sheet, StringCell, Workbook}

import scala.beans.BeanProperty
import scalaz.{-\/, \/-}

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2017/12/25
  */
class ReadUnit {
	var list: List[UnitScala] = List()

	def readExcel(): List[UnitScala] = {
		val readResult = Workbook("/Users/zcx/scalaExcelTest/基础信息模板20171221.xlsx")
			.map(workbook => workbook.sheets)
			.run
			.unsafePerformIO()

		readResult match {
			case -\/(exception) => throw new RuntimeException("Could not read file", exception)
			case \/-(sheets) => sheets.foreach(printSheet)
		}

		list
	}
	def printSheet(sheet: Sheet): Unit = {
		if(sheet.name.equals("用药单位表")){
			println(s"------------ ${sheet.name} ------------\n")
			val list:List[Row]  = sheet.rows.toList.filter( row => row.index != 0)
			list.foreach { row =>
				row match {
					case Row(_) =>  handleRow(row)
				}
			}
		}

	}
	def handleRow(row: Row): Unit = {
		val unit = new UnitScala;
		row.cells.toList.sortBy(_.index) .foreach { ss =>
			ss match {
				case StringCell(index, data) => addToList(index, data, unit)
				case NumericCell(index, data) => addToList(index, data.toString, unit)
				case FormulaCell(index, data) => addToList(index, data, unit)
				case _ => print("类型匹配错误")
			}
		}
		list = unit +: list

	}
	def addToList(index: Int, data: String, drug: UnitScala) ={
		index match {
			case 0 => if(!data.isEmpty) drug.drugCode = data
			case 1 => if(!data.isEmpty) drug.unit = data
			case _ =>

		}
	}
}

object ReadUnit extends App{
	def apply: ReadUnit = new ReadUnit()

	ReadUnit.apply.readExcel.foreach(ss => println(ss.drugCode, ss.unit))
}

/**
  * scala 中类的成员变量必须初始化， 否则编译不通过
  */
class UnitScala{
	@BeanProperty var drugCode: String = null
	var unit: String = null
}