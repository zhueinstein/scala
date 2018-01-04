package com.learn.study.typebounds

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2018/1/3
  *     java中的Comparator是一个外部比较器，而Comparable则是一个内部比较器
  *     类型参数
  *             Comparable与Comparator接口两者的本质不同，因此Ordering混入了Comparator，Ordered混入了Comparable，它们之间的区别和Comparable与Comparator间的区别是相同的
  */

case class Student_(name: String) extends Ordered[Student_]{
	override def compare(that: Student_): Int = {
		if(this.name < that.name) 1 else -1
	}
}
object TypeBound2  extends App{
	val st1 = Student_("Lily")
	val st2 = Student_("Lucy")
	println(st1.compare(st2))
}
/**
  *     上下文界定
  *             视图界定可以跨越类继承层次结构， 其后面的远离就是隐式转换
  *             下面的上下文界定采用隐式值来实现，上下文界定的类型参数形式为 T: M的形式， 其中M是泛型，这种形式要求一个M[T]的隐式值
  */
case class Persons(name: String){
	println(s"正在构建对象$name")
}
class PersonOrdering extends Ordering[Persons]{
	override def compare(x: Persons, y: Persons): Int = {
		if(x.name < y.name) -1 else 1
	}
}
//下面的代码定义了一个上下文界定
//它的意思是在对应作用域中，必须存在一个类型为Ordering[T]的隐式值，该隐式值可以作用于内部的方法
class Pair[T:Ordering](first: T, second: T){
	//smaller方法中有一个隐式参数，该隐式参数类型为Ordering[T]
	def smaller(implicit ordering: Ordering[T]): T ={
		if(ordering.compare(first, second) < 0)
			first
		else
			second
	}
	// 也可以引入orderingToOrdered的隐式转换
	import Ordered.orderingToOrdered
	def smaller2 ={
		if(first < second) first else second
	}
}
object PersonOrdering extends App{
	val ps1 = Persons("Lily")
	val ps2 = Persons("Lucy")
	implicit  val personOrdering = new PersonOrdering
	println(new Pair[Persons](ps1, ps2).smaller)
	println(new Pair[Persons](ps1, ps2).smaller2)

}

/**
  * 多重界定
  *     多重界定存在多种形式
  *             T:M:K // 这意味着在作用域内必须存在M[T]、K[T]类型的隐式值
  *             T<%M<%K //这意味着在作用域内必须存在T到M，T到K的隐式转换
  *             K>:T<:M // 这意味着K是T的超类，M也是T的超类
  */
class A[T]
class B[T]

class C
class D extends C
class E extends D{
	override def toString = s"E()"
}
object MultipleBound extends App{
	implicit val a = new A[String]
	implicit val b = new B[String]
	//多重上下文界定，必须存在两个隐式值，类型为A[T],B[T]类型
	//前面定义的两个隐式值a,b便是
	def test[T:A: B](x: String) = println(x)
	test("WeFon")

	implicit def t2A[T](x:T) = new A[T]
	implicit def t2B[T](x:T) = new B[T]
	//多重视图界定，必须存在T到A，T到B的隐式转换
	//前面我们定义的两个隐式转换函数就是
	def test2[T <% A[T]<% B[T]](x:String) = println(x)
	test2("WeFon2")

	def test3[C >:E <:D](x: E) = println(x)
	test3(new E)
}

/**
  *     类型约束
  *             类型变量界定、视图界定都是将泛型限定在一定的范围之内， 而上下文界定是将类型限定为某一类型
  *                    类型约束与下下文界定类型，只不过它是用于判断类型测试， 类型约束有以下两种
  *                             T=:=U // 用于判断T是否等于U
  *                             T<:<U // 用于判断T是否是U的子类
  */

//像上面的=:=符号很像一个操作符，但其实它是scala语言中的类，它们被定义在Predef当中
object TypeConstraint extends App{
	def test[T](name:T)(implicit ev: T<:<java.io.Serializable) = println(name)
	// 正确。 String 是 Serializable子类
	test("WeFon")
	//错误，因为Int类型不属于Seriablizable的子类
//	test(28)
}
//那么问题来了，test方法定义了一个隐式参数，它的类型是T <:< java.io.Serializable，即只有T为java.io.Serializable的子类才满足要求，但是我们在程序中并没有指定隐式值，为什么这样也是合法的呢？这是因为Predef中的conforms方法会为我们产生一个隐式值。
//那类型约束<:<与类型变量界定<:有什么区别呢？下面给出的代码似乎告诉我们它们之间好像也没有什么区别：
//
//但下面的代码给我们演示的是类型约束<:<与类型变量界定<:之间的区别：
//下面的代码演示的是其在一般函数使用时的区别
object Test01 extends App{
	def foo[A,B<:A](a:A,b:B) = (a, b)
	// 使用<: 类型不匹配时， 使用了类型推断， 即 Int => Any
	println(foo(1, List(1, 23, 3)))
	val list = List(2,4,5)
	println(list.isInstanceOf[Any])
	def bar[A,B](a:A, b:B)(implicit ev: B<:<A) = (a, b)
	//使用<:<时，严格匹配，不会采用类型推断
//	bar(1, List(1, 23, 3))
}
//下面的代码给出的是其在隐式转换时的区别
object Test02 extends App{
	class A
	class B
	def foo[B, A<:B](a:A, b: B) = println("Ok")
	implicit def a2B(a:A) = new B
	//经过隐式转换后，满足要求
	foo(new A, new B)

	def bar[A,B](a:A, b:B)(implicit ev: A<:<B) = println("Ok")
	//可以看到，隐式转换在<:<类型约束中不管用
//	bar(new A, new B)
}