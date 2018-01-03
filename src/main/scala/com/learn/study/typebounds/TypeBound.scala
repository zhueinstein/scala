package com.learn.study.typebounds

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
}
