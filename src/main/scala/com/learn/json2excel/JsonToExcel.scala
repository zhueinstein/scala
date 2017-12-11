package com.learn.json2excel

import java.io.File

import scala.io.Source
import scala.util.parsing.json.JSON
import scala.collection.immutable.Map
/**
  * 创建者： ZhuWeiFeng 
  * 日期：2017/12/11
  */
class JsonToExcel {
	def transform(uri: String){
		val file = new File(uri);
		val lines = Source.fromFile(file).mkString
		val maps = JSON.parseFull(lines)
		maps match {
			case None => println("解析失败")
			case Some(map: Map[String, Map[String, Any]]) =>  println(map)
			case Some(map: Map[String, String]) => handleMap(map)
			case other => println(other);
		}
	}
	def handleMap(map: Map[String, String]): Unit ={
		println(11)
		println(map.toList)
	}
	/*def  recursion(smap: Map[String, Map[String, String]]): List[Map[String, Any]] ={
		val list = List[Map[String, Any]]()
		smap.keys.map(key => {
			smap(key) match {
				case imap: Map[String, Map[String, String]] => Map("--" -> key) recursion(imap) :: list
				case iimap: Map[String, String] => iimap :: list
				case _ => println("解析失败")
			}
		})
	}*/

}
object JsonToExcel extends App{
	def apply: JsonToExcel = new JsonToExcel()
	JsonToExcel.apply.transform("/Users/zcx/Documents/数据分析.json")
}
