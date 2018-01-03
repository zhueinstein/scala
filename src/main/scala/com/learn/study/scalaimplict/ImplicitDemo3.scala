package com.learn.study.scalaimplict

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2018/1/3
  *     从代码中可以看到，隐式转换功能很强大，但同时也带来了程序复杂性性问题，在一个程序中如果大量运用隐式转换，特别是涉及到多次隐式转换时，会使代码理解起来变得比较困难，那到底要不要用隐式转换呢？下面给出我自己开发实践中的部分总结，供大家参考：
  *		1 即使你能轻松驾驭scala语言中的隐式转换，能不用隐式转换就尽量不用
  *		2 如果一定要用，在涉及多次隐式转换时，必须要说服自己这样做的合理性
  *		3 如果只是炫耀自己的scala语言能力，请大胆使用
  */
// 隐式参数中的隐式转换
object ImplicitParameter3 extends App {
	//下面的代码不能编译通过
	//这里面泛型T没有具体指定，它不能直接使用
	//<符号进行比较
//	def compare[T](first:T,second:T)={
//		if (first < second)
//			first
//		else
//			second
//	}
	//上面的代码要想使其编译通过，可以前类型变量界定和视图界定指定其上界为Ordered[T]，例如：
	def compare[T <% Ordered[T]](first: T, second: T) ={
		if(first < second)
			second
		else first
	}
	// 还可以使用隐式参数的隐式转换来实现
	def compare2[T](first:T, second: T)( implicit ore:T => Ordered[T])={
		if(first < second)
			second
		else first
	}
	println(compare2("a", "v"))

	// 隐式函数中的隐式转换使用概要
		//1、 如果参数没有使用柯里化的形式，下面的形式 implicit会作用与x、y两个参数上
	def sum(implicit x: Int, y:Int) = x + y
	// 下面这种形式的写法是错误的，如果函数没有柯里化，不能期望implicit会作用于一个参数上
//	def sum2(x: Int, implicit y: Int) = x +y
	// 2、并且implicit只能作用于最后一个柯里化的参数上
	def sum2( x: Int)(implicit y: Int) = x + y
	// 3、匿名函数不能使用implicit
//	val sum3 = (implicit x: Int) => x + 2
	//4、如果函数带有隐式参数，则不能使用其他的偏函数
		//不能定义sum的偏函数，因为它带有隐式参数
		//could not find implicit value for
		//parameter y: Int
		//not enough arguments for method sum:
		// (implicit y: Int)Int. Unspecified value parameter y.
//	val sum4 = sum2  _
	implicit val dd = 22
	println(sum2(1))
}

/**
  *     1\ 源类型到目标类型的转换只会进行一次，并不是说不存在多次隐式转换，在一般的方法调用过程中可能会出现多次隐式转换，例如：
  */
class A{
	override def toString = s"A()"
}
class B{
	override def toString: String = s"B()"
}
class C{
	override def toString = s"C()"
	def printC(c: C) = println(c)
}
class D

object ImplicitDemo3 extends App{
	implicit def B2C(b:B) ={
		println("B2C")
		new C
	}

	implicit def D2C(d:D)={
		println("D2C")
		new C
	}
	//下面的代码会进行两次隐式转换
	//因为ClassD中并没有printC方法
	//因为它会隐式转换为ClassC（这是第一次,D2C）
	//然后调用printC方法
	//但是printC方法只接受ClassC类型的参数
	//然而传入的参数类型是ClassB
	//类型不匹配，从而又发生了一次隐式转地换(这是第二次,B2C）
	//从而最终实现了方法的调用
	new D().printC(new B)
}

/**
  * 2、如果给函数定义了隐式参数，在实际执行过程中可能会发生多次隐式转换，代码如下：
  */
object Main extends App{
	class PrintOps() {
		def print(implicit i: Int) = println(i);
	}

	implicit def str2PrintOps(s: String) = {
		println("str2PrintOps")
		new PrintOps
	}

	implicit def str2int(implicit s: String): Int = {
		println("str2int")
		Integer.parseInt(s)
	}

	implicit def getString = {
		println("getString")
		"123"
	}

	//下面的代码会发生三次隐式转换
	//首先编译器发现String类型是没有print方法的
	//尝试隐式转换，利用str2PrintOps方法将String
	//转换成PrintOps（第一次）
	//然后调用print方法，但print方法接受整型的隐式参数
	//此时编译器会搜索隐式值，但程序里面没有给定，此时
	//编译器会尝试调用 str2int方法进行隐式转换，但该方法
	//又接受一个implicit String类型参数，编译器又会尝试
	//查找一个对应的隐式值，此时又没有，因此编译器会尝试调用
	//getString方法对应的字符串（这是第二次隐式转换，
	//获取一个字符串，从无到有的过程）
	//得到该字符串后，再调用str2int方法将String类型字符串
	//转换成Int类型（这是第三次隐式转换）
	"a".print
}
