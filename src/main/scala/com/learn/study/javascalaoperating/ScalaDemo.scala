package com.learn.study.javascalaoperating

import java.util
import java.util.Comparator

import scala.beans.BeanProperty

/**
  * 创建者： ZhuWeiFeng 
  * 日期： 2018/1/5
  *     Scala 与Java相互调用
  *
  */
// Java可以直接操作纵Scala类，如同Scala直接使用Java中的类一样
//Java似乎可以无缝操纵Scala语言中定义的类，在trait那一节中我们提到，如果trait中全部是抽象成员，则它与java中的interface是等同的，这时候java可以把它当作接口来使用，但如果trait中定义了具体成员，则它有着自己的内部实现，此时在java中使用的时候需要作相应的调整。我们先看下trait中全部是抽象成员的情况，例如：
object ScalaDemo extends App{
	def scalaMethod(x: Int) = println(x)
	def getList = {
		val list = new java.util.ArrayList[String]()
		list.add("Java")
		list.add("Scala")
		list.add("Spark")
		list
	}
	val list = getList
	// //因为list是java.util.ArrayList类型，所以下这条语句编译不会通过
//	list.foreach(println(_))
	//      引入下面这条语句后便可以调用scala集合中的方法，如foreach,map等, 这里真正起作用的是 导入的隐式转换
	//	import scala.collection.JavaConversions._
	import scala.collection.JavaConversions._
	list.foreach(println(_))
	// 显示的转换
	val listScala = asJavaIterable(getList)
	listScala foreach println _
}

//全部是抽象成员，与java的interface等同
trait MySQLDAO{
	def delete(id:String):Boolean
	def add(o:Any):Boolean
	def update(o:Any):Int
	def query(id:String):List[Any]
}

//部分实现，需要Java特殊处理
trait MySQLDAO1{
	def delete(id:String):Boolean = true
	def add(o:Any):Boolean
	def update(o:Any):Int
	def query(id:String):List[Any]
}

/**
  * 3、Scala 类型参数 与Java泛型相互操作
  *     Java中的泛型可以直接转换成Scala中的泛型，在前面的课程中我们已经有所涉及，
  *     例如Java中的Comparator<T> 可以直接转换成 Scala中的Comparator[T] 使用方法完全一样，不同的只是语法上的。下列代码给出了其使用方法
  */

case class Person(name:String ,age:Int)
//在Java中Comparator是这么用的：Comparator<Person>
//而在Scala中，是这么用的：Comparator[Person]

class PersonComparator extends Comparator[Person]{
	override def compare(o1: Person, o2: Person): Int = if(o1.age > o2.age) 1 else -1
}


object Demo3 extends App{
	val p1 = Person("WeFon", 111)
	val p2 = Person("WeFon2", 12)
	val personComparator = new PersonComparator
	println(personComparator.compare(p1, p2))
}

// Scala中使用， Java中的使用在JavaDemo中
//Student类用泛型定义，成员变量name及age指定泛型参数
//并且用注解的方式生成JavaBean规范的getter方法
//因为是val的，所以只会生成getter方法
class Student[T,S](@BeanProperty val name:T,@BeanProperty val age:S){

}

/**
  *     Java中的通配符与Scala中的通配符相互操作
  */

class ScalaExistTypeToJavaWildcardGeneric1{
	import java.util.List
	import scala.collection.JavaConversions._
	//采用Scala中的存在类型与Java中的能匹符泛型进行互操作
	def printList(x:List[T] forSome {type T}) ={
		x foreach println _
	}

	def printList2(x:List[_]) ={
		x foreach println _
	}
}
object Main extends App{
	val ss = new ScalaExistTypeToJavaWildcardGeneric1
	val list = JavaWildcardGeneric.getList
	ss.printList(list)
	ss.printList2(list)
}
