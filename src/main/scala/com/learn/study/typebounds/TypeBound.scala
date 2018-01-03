package com.learn.study.typebounds

import scala.runtime.RichInt

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2018/1/2
  *  类型参数
  *
  */
class TypeBound {

}

/**
  * 1、类型变量界定
  *     类型变量界定是指在泛型的基础上，对泛型的范围进行进一步的限定
  *     比如下面的compare方法上，对应于继承层次中，则是合法的， 否则编译报错
  */
class TypeVariableBound{
	// 如果不指定T的界定类型，则在编译的时候会报错，因为泛型T在编译的时候不知道确切的类型
		//即并不上所有的看类中都存在compareTo方法
	// 通过 T <: Comparable[T] 对T进行类型的限定， 指明所有的类型T都实现了Comparable的接口
	def compare[T <: Comparable[T]](a:T, b:T) ={
		if(a.compareTo(b) > 0) a
		else b
	}
}
object TypeVariableBound extends App{
	def apply(): TypeVariableBound = new TypeVariableBound()

	println(TypeVariableBound.apply().compare("A", "B"))

	val v1 = WeFon("Lily", 21)
	val v2 = WeFon("Lucy", 22)
	// 下面的代码会报错， 因为WeFon没有实现Comparable接口
//	println(v1.compareTo(v2))
	val we1 = WeFon2("Jim", 22)
	val we2 = WeFon2("Tom", 23)
	//此时下面这条语句是合法的，因为
	//Person类实现了Comparable接口
	println(we1.compareTo(we2))

}

//
case class WeFon(name:String, age: Int)

case class WeFon2(name: String , age: Int) extends Comparable[WeFon2]{
	override def compareTo(o: WeFon2): Int = {
		if(this.age > o.age) 1
		else if(this.age == o.age) 0
		else  -1
	}
}

/**
  * 对类中的泛型作范围限定
  *
  */
//定义Student类为case class，且泛型T的类型变量界定为AnyVal
//在创建类时，所有处于AnyVal类继承层次结构的类都是合法的
//如Int、Double等值类型
case class Student[S, T <: AnyVal](var name: S, high: T)

object StudentDemo extends App{
	//下面这条语句是不合法的，因为String类型不属于
	//AnyVal类层次结构
	// val S1=Student("john","170")
	//下面这两条语句都是合法的，因为
	//Int,Long类型都是AnyVal
	val S2=Student("john",170.0)
	val S3=Student("john",170L)
	val S4=Student("john",1701L)
}

/**
  * 视图界定
  *     视图界定使用<%来实现
  *      视图界定比类型变量界定限制要宽松一点，它不但可以是类继承层次结构中的类，也可以是跨越类继承层次结构的类，在后台的实现是隐式转换
  */
case class Lily[T, S <: Comparable[S]](name: T, age: S)
object Lily extends App{
	val lily = Lily("Lily", "20")
	// 编译不通过， 因为Int没有实现Comparable接口
//	val lily2 = Lily("Lily", 20)
}
// 利用<%符号来对S进行限定，它的意思是S可以是Comparable类继承层次结构中实现了Comparable接口的类，
// 也可以是能够经过隐式转换得到的类， 该类实现了Comparable接口
case class Lucy[T, S <% Comparable[S]](name: T, age: S)
object Lucy extends App{
	// Int 在后台被隐式转换成了RichInt类
	val lucy = Lucy("Lucy", 20)
}

/**
  *	上界 < : 和下界 >:
  *             如T < : AnyVal  表示类型T的最顶层类是AnyVal， 所有输入AnyVal的子类都是合法的
  *             如 R>: T 表示泛型R的类型必须是R类型的超类
  */

case class UpperBound[S, T <: AnyVal](name: T, high: T)
class Pair1[T](val first: T, val second: T){
	//下界通过[R >: T]的意思是
	//泛型R的类型必须是T的超类
	def replaceFirst[R >: T](newFirst: R) = new Pair1[R](newFirst, second)

	override def toString = s"Pair1($first, $second)"
}

class Book(val name: String){
	override def toString = s"Book($name)"
}

class EBook( name: String) extends Book(name)
class PBook( name: String) extends Book(name)
class WireBook( name: String) extends PBook(name)

object LowerBound extends App{
	val first = new Book("hello")
	val second = new PBook("paper book")
	val p1 = new Pair1(first, second)
	println(p1)
	val newFirst = new Book("Replace Book")
	val p2 = p1.replaceFirst(newFirst)
	println(p2)

	val wireBook: WireBook = new WireBook("WireBook")
	val p3 = p1.replaceFirst(wireBook)
	println(p3)

	val p4:Pair1[PBook] = new Pair1(second, second)
	println(p4)

	val thirdBook = new Book("Super Book")
	val p5 = p4.replaceFirst(thirdBook)
	println(p5)

	// 下面可以编译通过，p1:Pair1[Book], p1.replaceFirst()，可知T为Book，R>:T,由此可知R至少为Book类型，
	//而传入参数为WeirdBook,所以共同基类就是Book，推测R为Book类型，replaceFirst[Book>:Book](weirdFirst:Book)
	val p6: Pair1[PBook] = p4.replaceFirst(wireBook)
	println(p6)


}