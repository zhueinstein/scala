package com.learn.study.advancedType
import scala.reflect.runtime.universe._

/**
  * 创建者： ZhuWeiFeng 
  * 日期： 2018/1/4
  *     高阶类型 三
  *             在scala中，类(class)与类型(type)是两个不一样的概念。
  *             我们知道类是对同一类型数据的抽象，而类型则更具体。
  *             比如定义class List[T] {}, 可以有List[Int] 和 List[String]等具体类型，称List为类，而List[Int]、List[String]则为类型。
  *             从这方面看：类型一致的对象它们的类也是一致的；而类一致的，其类型不一定一致
  *
	类型	        语法类型
	类	        class Person
	特质	        trait Closable
	元组类型	(T1,T2,T3,…)
	函数类型	(T1,T2,t3,…)=>T
	参数类型（泛型）	class Person[T1,T2,…]
	单例类型	this.type
	类型投影	Outter#Inner
	复合类型	A with B with C…
	结构体类型	{def f():Unit ….}
	中置类型	T1 A T2
	存在类型	T forSome {}
  */
object AdvancedTypeThree extends App{
	// 类相同， 同属于List 类
	println(classOf[List[Int]] == classOf[List[String]])
	// 类相同， 类型不一定相同
	println(typeOf[List[Int]] == typeOf[List[String]])
}

/**
  *     1、Type Specialization
  *	        Type Specialization，一般被翻译成类型专门化，它主要是用来解决泛型的类型擦除和自动装箱拆箱的问题。
  *	        在JAVA语言当中，泛型生成字节码文件时会进行泛型类型擦除，类型擦除后利用上界类型（一般是Object）来替代，
  *	        但这么做的话有问题，这是因为在Java语言中基本类型与对象类型是不能相互引用的，java中的基本类型不能使用泛型。
  *	        解决方案是利用对应的对象类型来进行替代，例如int对应Integer类型，但这种方式并不能解决根本问题。
  *	        为方便后面Type Specialization的理解，我们先从java的类型擦除、自装箱与拆箱讲起。
  *	                java代码 演示在jav的 com.learn.generictype中演示
  */
/**
  * Scala中的Type Specialization解决了这些问题。它的语法很简单，通过注解进行类型专门化声明，如：
  *  代码编译后会生成9个版本的List，分别对应scala中的九种基本类型即Unit, Boolean, Byte, Short, Char, Int, Long, Float, Double
  */
abstract class Lists[@specialized T]{
	def apply(x:T)
	def map(x:T)
}
//@specialized 还可以更细致，可以限定某几个类型
abstract class ListOne[@specialized T]{
	// 指定生成Int版本
	def apply[@specialized (Int) S](x: T):S
	//指定生成(Int, Double)版本
	def map[@specialized (Int, Double) S]:(Int, Double)
}

/**
  *     2、Manifest、TypeTag、ClassTag
  *             由于类型擦除的影响，编译期存在的类型信息在编译后不存在了，在程序运行时不能获取该信息，
  *             但某些场景下可能需要得到编译期的类型信息，scala能够做到这一点，它通过Manifest和TypeTag来保存类型信息并在运行时使用该信息。
  *             那Manifest与TypeTag有什么区别呢？
  *                     Manifest在scala.reflect包中，它在scala.reflect包中，而TypeTag 在scala.reflect.runtime.universe包中定义；
  *                     TypeTag可以用来替代Manifest，功能更强大一点，Manifest不能识别路径依赖类型，例如对于class Outter{ class Inner}，
  *                     假设分别创建了两个不同的外部类，outter.Inner, outter2.Inner， Manifest就会识别为同一类型，而TypeTag不会，
  *                     另外TypeTag可以使用typeOf[T] 来检查类型参数。
  */
object ManifestType extends App{

	def print1[T](x:scala.collection.immutable.List[T])(implicit m: Manifest[T]) ={
		if(m <:< manifest[String]){
			println("字符串类型的List")
		}else
			println("非字符串类型的List")
	}

	//隐式参数m由编译器根据上下文自动传入，例如print1(List(“one”, “two”)) ，编译器会根据”one”,”two” 实际类型推断出 T 的类型是 String，再隐式地传入了Manifest[String]类型的对象参数，使得运行时可以根据这个参数做更多的事情
	print1(List("one", "two"))
	print1(List(1,3))
	/**
	  *     如何使用TypeTag
	  */
	def getTypeTag[T: TypeTag](a :T) = println(typeTag[T])
	//typeTag返回的是具体的类型，而不是类型擦除之后的类型any，即TypeTag保存所有具体的类型。在运行时可以通过模式匹配来精确地对类型进行判断：
	getTypeTag(List("String", "22"))

	//def typeOf[T](implicit ttag: TypeTag[T]): Type = ttag.tpe
	def patternMatch[T: TypeTag](a: List[T])= typeOf[T] match {
		case t if t =:= typeOf[String] => println("Lists of Strings ")
		case t if t <:< typeOf[Int] => println("Lists of Ints ")
			case _ => println("Lists of Others")
	}
	patternMatch(List("d","asd"))

	//上边的typeOf[A]在传入参数为List(“String”)时，得到结果是java.lang.String。typeOf[A]接受一个类型为TypeTag[a]的隐式参数，编译器生成的TypeTag隐式参数会被传给typeOf[A] 。 有4种TypeTag:
		//1 scala.reflect.api.TypeTags#TypeTag. A full type descriptor of a Scala type. For example, a TypeTag[List[String]] contains all type information, in this case, of typescala.List[String].
		//2 scala.reflect.ClassTag. A partial type descriptor of a Scala type. For example, a ClassTag[List[String]] contains only the erased class type information, in this case, of type
		//3 scala.collection.immutable.List.ClassTags provide access only to the runtime class of a type. Analogous to scala.reflect.ClassManifest.
		//4 scala.reflect.api.TypeTags#WeakTypeTag. A type descriptor for abstract types (see corresponding subsection below).

	//这给出最常用的ClassTag的用法：ClassTag[T]保存了被泛型擦除后的原始类型T,提供给运行时程序使用。
	println(classOf[String])
}




