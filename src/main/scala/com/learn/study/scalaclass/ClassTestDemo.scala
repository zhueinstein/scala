package com.learn.study.scalaclass

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2017/12/25
  */
object ClassTestDemo extends App{
	val person = new Person("Weefun")
	println(person)
	// 对于将主构造器设置为私有的， 在编译时如果不是在本类中调用会报错
	//val peerson3 = new Person3("tom", 22)
	val person3 = Person3("Jerry", 23)
	println(person3)
	val person3_1 = new Person3_11("adc", 22)
	println(person3)
	val person4 = new Person4();
	println(person4)

}
