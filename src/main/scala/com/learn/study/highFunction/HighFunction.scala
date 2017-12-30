package com.learn.study.highFunction

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2017/12/29
  *     高阶函数
  *             高阶函数有两种：
  *                     1、将一个函数当作另一个函数的参数（函数参数）
  *                     2、返回值是函数的函数
  *       部分函数：
  *             部分函数，就是指：当函数有多个参数时，而我们在使用该函数时，不想提供所有的参数（比方说3个参数，我们只提供0-2个参数），
  *             此时得到的函数就是部分函数
  */
class HighFunction {
	//// 参数是函数的高阶函数
	def convertIntToString(f:(Int) => String): String = f(4)
	def words(lines: Seq[String]):Seq[String] = lines flatMap (line => line split "\\W+")
	// 返回值是函数的高阶函数, 生产的是偏函数
	def multiplyBy(factor: Double) = (x: Double) => factor * x

	// 函数柯里化
	def currfyBy(x: Double)(y:Double):Double = x*y

	// 部分函数
}

object HighFunction extends App{
	val highFunction = new HighFunction
	println(highFunction.convertIntToString((x: Int) => x + " s"))
	highFunction.words(Seq("I am a boy", "who are you")).foreach(println(_))
	// 函数柯里化
	println(highFunction.multiplyBy(3)(3))
	// 生成一个偏函数
	println(highFunction.multiplyBy(3))
	// scala中常用的高阶函数
	// 1、map函数， 所有的集合都存在map函数
	//      def map[B](f: (A) ⇒ B): Array[B]
	//	用途：Builds a new collection by applying a function to all elements of this array.
	//		B的含义：the element type of the returned collection.
	//	f的含义：the function to apply to each element.
	//		返回：a new array resulting from applying the given function f to each element of this array and collecting the results.

	// Array
	Array("spark", "scala", "java").map((x: String) => x* 2).foreach(println(_))
	//     省略匿名函数的类型
	Array("spark", "scala", "java").map((x) => x* 2).foreach(println(_))
	//  单个参数，可以省略掉括号
	Array("spark", "scala", "java").map(x => x* 2).foreach(println(_))
	//参数在右边只出现一次的话，可以使用占位符表示方式
	Array("spark", "scala", "java").map( _* 2).foreach(println(_))
	// List Map
	val list=List("Spark"->1,"hive"->2,"hadoop"->2)
	list.map(_._1).foreach(println(_))
	// Map 类型
	Map("spark"->1,"hive"->2,"hadoop"->3).map(_._1)

	//2、flatMap函数
	List(List(1,2,3),List(4,5,6)).flatMap(x=>x).foreach(print(_ ))
	println()
	List(List(1,2,3),List(4,5,6)).flatMap(x=>x.map(y => y)).foreach(print(_ ))
	println()
	//3、filter函数
	Array(1,2,3,4,5).filter(_ >3).foreach(println(_))
	List("spark", "Java", "Scala").filter(_.length > 4).foreach(println)
	Map("List"->3,"Set"->5,"Array"->7).filter(_._2>3).foreach(println)
	//4、reduce函数
	println(Array(1, 2, 3, 4).reduce(_ + _))
	Array(1, 2, 3, 4).reduceLeft((x, y) => {println(x,y); x+y})
	Array(1, 2, 3, 4).reduceRight((x, y) => {println(x,y); x+y})
	// 5、fold函数
	Array(1, 2, 3, 4,333).foldLeft(0)((x,y) => {println(x,y); x})
	Array(1, 2, 3, 4).foldRight(0)((x,y) => {println(x,y); x+y})
	// /: 相当于foldLLeft
	println((0 /: Array(1, 2, 3, 4)) (_ + _))
	// 6、scan函数， 每一步的执行结果都保存起来，执行完后生成数组, 第一个参数指的是初始值
	println(Array(1, 3, 4, 55, 6, 6, 6, 6, 36, 7, 8).scanLeft(100)((x, y) => {
		print(x, y); x + y
	}))
	List("spark", "Java", "Scala").scanLeft("[")((x, y) => {println(x+"]", y); x+y})
	println(highFunction.currfyBy(3)(4))
	// 部分函数的应用
	 // 定义一个部分函数
	// _ 在这里不是占位符号，而是作为部分应用函数的定义符
	val p = print _
	Array(2,34,4,5,4,2).foreach(p)
	println()

	// 定义一个求和函数
	def sum(x: Int)(y:Int)(z:Int) = x + y + z
	// 不指定任何参数的部分应用函数
	def sum0 = sum _
	println(sum0(1)(2)(3))
	// 指定两个参数的部分应用函数
	def sum2 = sum(1) (_:Int) (3)

	println(sum2(2))

	// 定义一个参数的额部分应用函数
	def sum1 = sum (_:Int)(2) (_:Int)

	println(sum1(1,3))
}
