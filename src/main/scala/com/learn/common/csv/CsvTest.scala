package com.learn.common.csv

import com.gingersoftware.csv.ObjectCSV
/**
  * 创建者： ZhuWeiFeng 
  * 日期： 2018/2/11
  */
case class Person (name: String, age: Int, salary: Double, isNice:Boolean = false)
object CsvTest extends App{
	val person1 = new Person("Doron,y",10,5.5)
	val person2 = new Person("David",20,6.5)
	ObjectCSV().writeCSV(IndexedSeq(person1,person2), "/Users/zcx/Downloads/csvTest")

}
