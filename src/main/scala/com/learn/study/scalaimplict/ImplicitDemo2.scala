package com.learn.study.scalaimplict

import java.io.File

import scala.io.Source

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2018/1/3
  *     1、隐式转换可以定义在目标文件当中
  *     2、隐式转换函数与目标代码在同一个文件当中，也可以将隐式转换集中放置在某个包中，在使用进直接将该包引入即可
  *     那什么时候会发生隐式转换呢
  *             1、当方法中参数的类型与实际类型不一致时
  *             2、当调用类中不存在的方法或成员时，会自动将对象进行隐式转换
  *      什么时候不会发生隐式转换
  *             1、编译器可以不在隐式转换的编译通过，则不进行隐式转换
  *             2、如果转换存在二义性，则不会发生隐式转换
  *             3、 隐式转换不会嵌套进行 比方说 先定义了File 到 RichFile的隐式转换 然后又定义了 RichFile 到RichFile2的隐式转换 ， 则File 不会直接到RichFile2的嵌套隐式转换
  *                     即是 隐式转换从源类型到目标类型不会多次进行，也即源类型到目标类型的转换只会进行一次
  */
object ImplicitDemo2 extends App{
	// 隐式转换函数
	implicit def str2Int(x:String) = x.toInt
	val x:Int = "23"

	// 在RichFile类中定义read方法
	implicit def file2RichFile(file: File) = new RichFile(file)
	val content = new File("/Users/zcx/体检表.sql").read
	println(content)

}

class RichFile(val file: File) {
	def read = Source.fromFile(file).getLines().mkString(",")
}

/**
  *  隐式参数
  *
  */
class Student(var name:String){
	//将Student类的信息格式化打印
	def formatStudent(outputFormat:OutputFormat)={
		outputFormat.first+" "+this.name+" "+outputFormat.second
	}
}

case class OutputFormat(var first:String,val second:String)

object ImplicitParameter {
	def main(args: Array[String]): Unit = {
		val outputFormat=new OutputFormat("<<",">>")
		println(new Student("john").formatStudent(outputFormat))
	}
}

// 将上面的函数传递参数的形式修改为隐式参数的形式
class StudentImplicit(name: String){
	def description(implicit outputFormat: OutputFormat): Unit ={
		val first = outputFormat.first
		val second = outputFormat.second
		println(s"$first $name $second")
	}
}

object ImplicitParameter2 extends App{
	//程序中定义的变量outputFormat被称隐式值
	implicit val outputFormat = OutputFormat("<<" , ">>")
	val studentImplicit = new StudentImplicit("张无忌")
	//在.description方法时，编译器会查找类型
	//为OutputFormat的隐式值,本程序中定义的隐式值
	//为outputFormat
	studentImplicit.description
}