package com.learn.study.advancedType

/**
  * 创建者： ZhuWeiFeng 
  * 日期： 2018/1/4
  *     高阶类型 二
  *             语法糖（Syntactic sugar），也译为糖衣语法，是由英国计算机科学家彼得·约翰·兰达（Peter J. Landin）发明的一个术语，指计算机语言中添加的某种语法，
  *             这种语法对语言的功能并没有影响，但是更方便程序员使用。通常来说使用语法糖能够增加程序的可读性，从而减少程序代码出错的机会。
  *                     例如，泛型它就是一种语法糖，即使不用泛型，也能开发出同等功能的程序，例如排序算法，我可以分别实现Double、Int等类型的排序算法，
  *                     但是我们使用泛型之后，可以大大简化程序设计，减少重复代码的编写，代码可读性也有所增加。
  */

/**
  *     1、中置类型
  *             在scala中存在着中置操作符，如1+2等，+在这被称为中置操作符，前面我们说过，scala中的一切操作皆为对象调用，1+2其实是1.+(2)的对象方法调用。
  *             在scala中同样存在着中置类型，如：
  */
class Person1[T,S](val name:T, val age: S){
	// 下面的中置写法相当于 val p: Person[String, Int] = null
	val p: String Person1 Int = null

}
/// 可以看到，如果类的泛型有两个的话，就可以使用中置表达式来进行进行变量的定义， 中置最常用的场景是 模式匹配
case class Dog[T,S](name: T, age: S)
object InfixType extends App{
	val dog: String Dog Int = Dog("小黄1", 2)
	//中置表达式的模式匹配用法
	//模式匹配时可以直接用常量，也可以直接用变量
	dog match {
		case Dog("小黄", 2) => println("非中置形式")
		case "小黄" Dog 2 => println("Matching Success")
		case name Dog age => println(s"Matching Failed $name, $age")
	}

}

/**
  * 2、存在类型
  *
  */
object  ExistsType extends App{
	val array = Array(1,2,3)
	// Array[_]是一种存在类型， 虽然用的是类型通配符， 但他的本质等同于 print2的写法形式，这是一种语法糖，用于简化设计
	 def print2(x:Array[T] forSome {type T}) = print(x)
	def print(x: Array[_]) = println(x)
	print(array)
	print2(array)

	// Map[_,_] 这也是一种语法糖，用于简化设计
	val map = Map(1 -> "a", 2 ->"b")
	def print3(x:Map[_,_]) = println(x)
	def print4(x:Map[T,U] forSome {type T ;type U}) = println(x)
	print3(map)
}

/**
  *  3、函数类型
  *      函数也具有类型
  *             Function2对应的类型定义部分代码如下：

			trait Function2[@specialized(scala.Int, scala.Long,
			scala.Double) -T1, @specialized(scala.Int, scala.Long,
			scala.Double) -T2, @specialized(scala.Unit,
			scala.Boolean, scala.Int, scala.Float, scala.Long,
			 scala.Double) +R] extends AnyRef
		在scala中还存在单个参数的Function类型即Function1，它的类型定义部分代码如下：

		//@annotation.implicitNotFound
		(msg = "No implicit view available from ${T1} => ${R}.")
		trait Function1[@specialized(scala.Int,
		 scala.Long, scala.Float, scala.Double,
		(scala.Unit, scala.Boolean, scala.Int,
		 scala.Float, scala.Long, scala.Double,
		  scala.AnyRef) +R] extends AnyRef

  */
object Demo10 extends App{
	def max(a: Int, b:Int) = if(a > b) a else b

	//通过Funtion2定义一个输入参数为两个整型
	//返回类型为Int的函数,这里是通过new创建创建函数
	//而这个类正是Function2，它是函数类型类
	val anonfun2 = new Function2[Int, Int, Int] {
		override def apply(v1: Int, v2: Int): Int = if(v1 > v2) v1 else v2
	}

	println(max(2, 3) == anonfun2(2, 3))

	//通过源码可以看到 输入参数是逆变的 使出参数是协变的
	// 以下代码给的是输出类型是协变的替代
	class AA
	class BB
	class CC extends BB
	// 定义一个输入参数是AA， 输出是CC的函数字面量
	val x = (p:AA) => new CC
	// 定义了一个函数变量x2，它是一个函数类型，
	// 该函数的输入是AA类型，输出是BB类型， 由于BB是CC的超类Function1的输出参数又是协变的，因此代码是合理的
	val x2: AA => BB =x

	// 以下代码是输出类型是逆变的代替
	class R
	class X
	class Y extends X
	// 创建输入类型是X的，输出类型是R的字面量
	val f1 = (x:X) => new R
	//下面的代码定义的变量f2是一个输入类型是Y，返回值类型是R
	//的函数字面量，它被赋值为f1，由于输入类型是逆变的，也就是
	//说Y是X的子类型，X=>R则是Y=>R的子类型，因此下面的代码是合法的
	val f2:( Y => R) = f1

}

/**
  *     4、抽象类型
  *             只在抽象类或者特质中利用type关键字定义的没有类型的标识，该标志在子类中被确定，称这种类型为抽象类型
  */
abstract class AbstractType{
	// 定一个抽象类型，在子类中被确定
	type IdentityType

	def getIdentityTypeNo():IdentityType
}
class Student100 extends AbstractType{
	override type IdentityType = String

	override def getIdentityTypeNo(): String  = "100"
}
class Teacher100 extends AbstractType{
	override type IdentityType = Int
	override def getIdentityTypeNo()= 1000
}
object Student100 extends App{
	val student100 = new Student100
	println(student100.getIdentityTypeNo())
	val teacher100 = new Teacher100
	println(teacher100.getIdentityTypeNo())
}
// 抽象类型也可以用泛型实现
abstract class AbstractType1[T]{
	def getIdentityTypeNo():T
}
class Student101 extends AbstractType1[String]{
	override def getIdentityTypeNo(): String = "100"
}
class Teacher101 extends AbstractType1[Int]{
	override def getIdentityTypeNo(): Int = 1000
}

object Student101 extends App{
	val student101 = new Student101
	println(student101.getIdentityTypeNo())
	val teacher101 = new Teacher100
	println(teacher101.getIdentityTypeNo())
}
//在实际应用中，如果类型是在实例化的时候给定的，推荐用类型参数进行类的定义，例如经常需要用到new Person[String,Int]（”摇摆少年梦”,18）这种创建对象的方式，此时使用泛型更为方便；
// 如果类型是在子类型中才被确定，则推荐使用抽象类型。例如，从代码的简洁性方面考虑，下面的代码使用抽象类型的话更”省“
// 抽象类型
trait Closable{
	type  in
	type out
	def close(x: in): out
}
class File extends Cloneable{
	type in = String
	type out = Boolean
	def close(x:in): out = true
	def open(x:in):out = false
	//....其它方法
}
// 参数类型
trait Closable2[T,S]{
	def close(x:T):S
}
class File2 extends Closable2[String, Boolean]{
	override def close(x: String): Boolean = true
	def open(x: String) : Boolean = false
	//....其它方法
}
//当File类中还有大量的方法要用到String及Boolean类型时，抽象类型的优越性就能表现出来。

object AdvancedTypeTwo {

}
