package com.learn.common.excel

import com.alibaba.fastjson.JSON
import com.google.gson.Gson
import info.folone.scala.poi.{FormulaCell, NumericCell, Row, Sheet, StringCell, Workbook}

import scala.reflect.runtime.{universe => ru}
import scalaz.{-\/, \/-}

/**
  * 创建者： ZhuWeiFeng 
  * 日期： 2018/2/9
  */
class CommonExcelUtil[T: ru.TypeTag](clazz: Class[T])(localUrl: String){
	val gson = new Gson()
	var seqIndex = 0
	var params = Map.empty[Int, String]
	val (ctorm, parametersAndType) = getCtorAndParametrs[T]
	parametersAndType.foreach(ds => {params += (seqIndex -> ds._1); seqIndex +=1})

	var finalList = List.empty[T]
	def readExcel(sheetName: String): List[T]={
		val readResult = Workbook(localUrl)
			.map(workbook => workbook.sheets)
			.run
			.unsafePerformIO()
		readResult match {
			case -\/(exception) => throw new RuntimeException("Could not read file", exception)
			case \/-(sheets) => sheets.foreach(sheet => handleSheet(sheet)(sheetName))
		}
		finalList
	}

	def handleSheet(sheet: Sheet)(sheetName: String): List[T] ={
		// 只能针对sheetName来单独处理
		if(sheet.name == sheetName){
			println(s"------------ ${sheet.name} ------------\n")
			val gson = new Gson()
			sheet.rows.toList.foreach { row =>
				// 对Row进行匹配模式
				row match {
					case Row(index, _) => {
						if (index > 0 && index <= 160) {
							var  item = Map.empty[String, AnyRef]
							row.cells.toList.sortBy(_.index) .foreach { ss =>
								for( (key, value) <- params ){
									if(key == ss.index){
										ss match {
											case StringCell(_, data) => item += (value -> data)
											case NumericCell(_, data) => item += (value -> data.toString)
											case FormulaCell(_, data) => item += (value -> data.toString)
											case _ => Some(None)
										}
									}
								}
							}
							finalList = JSON.parseObject(gson.toJson(scala.collection.JavaConversions.mapAsJavaMap(item)), clazz) :: finalList
						}
					}
				}
			}
		}
		finalList
	}
	 def getCtorAndParametrs[T: ru.TypeTag]() :(ru.MethodMirror, List[(String, ru.Type)]) = {
		val runtimeMirror = ru.runtimeMirror(getClass.getClassLoader)
		val typeObj = ru.typeOf[T]
		val outputClass = typeObj.typeSymbol.asClass
		val cm = runtimeMirror.reflectClass(outputClass)
		val ctorSymbol = typeObj.decl(ru.termNames.CONSTRUCTOR)
		if (ctorSymbol == ru.NoSymbol)
			throw new IllegalArgumentException(s"type $typeObj should have a primary constructor but doesn't")
		val ctor = ctorSymbol.asMethod
		val parametersAndType: List[(String, ru.Type)] = ctor.paramLists.head.map(p => (p.name.decodedName.toString, p.typeSignature))
		val ctorm: ru.MethodMirror = cm.reflectConstructor(ctor)
		(ctorm, parametersAndType)
	}
}

object CommonExcelUtil{
	def apply[T: ru.TypeTag](clazz: Class[T])(localUrl: String): CommonExcelUtil[T] = new CommonExcelUtil(clazz)(localUrl)
}


object Test extends App{

	val members = Map[Int, String](0 -> "drugCode", 1 -> "commonName")
	val sheetName = "药品汇总"
	val lists = CommonExcelUtil[DrugTest](classOf[DrugTest])("/Users/zcx/Downloads/药品分级基础数据汇总_20171208.xlsx").readExcel(sheetName)
	lists.foreach(ds => println(ds.commonName))
}
case class DrugTest(drugCode: String, commonName: String)


object ReflectDemo extends App{
//	println(Source.fromFile("/Users/zcx/Downloads/药品分级基础数据汇总_20171208.xlsx").getLines())
//	   println(getCtorAndParametrs[DrugTest]()._2)
	val mp = ("drugCode" -> "123", "commonName" -> "Dikang")
	mp.asInstanceOf[DrugTest]
}

