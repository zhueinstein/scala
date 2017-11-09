package com.learn.testing

/**
  * Created by zcx on 2017/9/25.
  */
object Testing extends App{
	// (message: String) => println(content + " " + message) 匿名函数
	// fuc_returned(content: String) 函数
	def fuc_returned(content: String) = (message: String) => println(content + " " + message)
	//
	def returned = fuc_returned("Spark")
	returned("Scala")

	def spark(func: (String) => Unit, name: String) = func(name)
	// 如果函数作为参数，函数只有一个参数，可以使用_代替， （）也可以省略
	spark(print, "Hello" )
	val array = Array(1,2,3,4,5,6,7,8,9,10)

	array.foreach(println)
	// 闭包 能够读取内部函数的变量




}
