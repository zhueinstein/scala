package com.learn.study.advancedType
import scala.reflect.runtime.universe.typeOf
/**
  * 创建者： ZhuWeiFeng 
  * 日期：2018/1/4
  *     高阶类型 一
  *             1、this.type
  */
/**
  *     1、this.type
  */
class Person {
	private var name: String = null
	private var age: Int = 0
	def setName(name: String):this.type ={
		this.name = name
		// 返回这个对象本身
		this

	}
	def getName= name
	def getAge = age
	def setAge(age: Int):this.type ={
		this.age = age
		// 返回对象本身
		this
	}
	override def toString = s"Person($name, $age)"
}
object Demo1 extends App{
	// 链式调用
	println(new Person().setName("WeFon").setAge(29))
}
// 但是当涉及到继承的时候，这种机制就会出现一些问题
class Student extends Person{
	private var studentNo: String = null
	def setStudentNo(studentNo: String)={
		this.studentNo = studentNo
		this
	}

	override def toString = s"Student($getName, $getAge, $studentNo)"
}
object Demo2 extends App{
	// setName、setAge的返回类型是this的时候，下面的代码会报错， 原因是Student在调用setName、setAge的时候，返回的仍然是Person，但是Person类并没有setStudentNo方法
	// 把setName、setAge方法的返回类型修改为this.type就可以,下面代码就没有问题了 因为this.type返回实际类型,
	println(new Student().setName("WeFon").setAge(29).setStudentNo("001"))
}

/**
  *  2、投影类型
  *     对于不用对象的内部类，使不同的类，他们的路径依赖不一样
  */
class Outer{
	private val x: Int = 0
	val inner: Inner = new Inner
	def showInner(in: Inner) = println(in.showX)
	class Inner{
		def showX = x
	}
}
object Demo3 extends App{
	val outer = new Outer
	val inner =  new outer.Inner
	val outer2 = new Outer
	val inner2 =  new outer2.Inner
	//下面的代码编译会失败
	//这是因为不同outter对象对应的内部类成员类型是不一样的
	//这就跟两个类成员的实例它们内存地址不一样类似
//	outer.showInner(inner2)
	//下面的类型判断会输出false
	//这也进一步说明了它们类型是不一样的
	println(typeOf[outer.Inner] == typeOf[outer2.Inner])
}
// 路径依赖类型： 上述代码中的 def showInner(in: Inner) = println(in.showX) 成员方法中的Inner相当于def showInner(in:this.Inner) =  println(in.showX)
// 或者是 def showInner(in: Outer.this.Inner) = println(in.showX), 也即它依赖于外部类， 整体的话构成一路径， 因此也被称为路径依赖
        // 内部类的使用情况
	// 1、内部类本身
class Outer1 {
	var inner: Inner = new Inner
	def print(inner: Inner) = inner
	class Inner {

	}
}
	//2、子类使用父类中的内部类
class OuterSub extends Outer1{
		private val inner1: Inner = new OuterSub.super.Inner
	}
	// 3、其他类或者对象中使用
class Other{
		def main(args: Array[String]): Unit = {
			val outer = new Outer1
			val inner = new outer.Inner
		}
	}

////  类型投影的目的就是，将外部类Outer 中的定义的方法def printInner(in:Inner) = println(in.showX)可以接受任意外部类中的Inner类
class Outer3 {
	private val x:Int = 0
	private val inner: Inner = new Inner
	//Outer#Inner类型投影的写法
	//可以接受任何outer对象中的Inner类型对象
	def print(inner: Outer3#Inner) = println(inner.getX)
	class Inner{
		def getX = x
	}
}
object Demo4 extends App{
	val outer = new Outer3
	val inner = new outer.Inner

	val outer1 = new Outer3
	val inner1 = new outer1.Inner

	outer.print(inner1)
	//注意，下面的这条语句返回的仍然是false，我们只是对print方法中的
	//参数进行类型投影，并没有改变outter.Inner与outter2.Inner
	//是不同类的事实
	println(typeOf[outer.Inner] == typeOf[outer1.Inner])
}

/**
  *     3、结构类型
  *             结构类型利用反射机制，为静态语言添加动态特性，从而使得参数类型不受限于某个已经命名的类型
  */
object StructureType extends App{
	// releaseMemory的参数是一个结构体类型，它定义了一个抽象方法，对close方法的规格进行了说明
	def releaseMemory(res: {def close():Unit}): Unit ={
		res.close()
	}

	// 使用结构体类型
	releaseMemory(new {def close():Unit = {println("它关闭了")}})

//	另外结构体类型还可以用type关键字进行声明，如：
	type X= {def description():Unit}
	def descriptions(x:X) = {
		x.description()
	}
	descriptions(new {def description():Unit ={println("🐘，是世界上最大的动物吗？很显然，这是不对的")}})
	// 结构体类型其实可以看作是一个类，在函数调用时，直接通过new操作来创建一个结构体类型对象，当然他是匿名的，
		//因此，上面的方法也可以传入一个实现了description的方法的单例对象或者类
	class Description {
		def description():Unit = {
			println("🐘，是世界上最大的动物吗？很显然，这是不对的")
		}
	}
	object Description1{
		def description():Unit = {
			println("🐘，是世界上最大的动物吗？很显然，这是不对的")
		}
	}
	// 对于类， 直接创建对象传入参数即可
	descriptions(new Description)
	// 对于单例对象，直接传入单例对象即可
	descriptions(Description1)
}
//我们可以看到，虽然说定义的方法中的参数是一个结构体类型，但是我们也可以传入普通类对象和单例对象，只要该对象或类中具有结构体类型中声明的方法即可。上述代码也告诉 我们，其实结构体类型也是一个类，只是表现形式与类有所区别而已。
/**
  *     4、复合类型
  */
class A
class B extends A with Cloneable{

	override def toString = s"B()"
}
// A with Cloneable 就可以看作是一个复合类型，可以使用type 定义 type X = A with Cloneable
object CompoundDemo extends App{
	type X = A with Cloneable
	def test(x:X) = println(x)
	test(new B)
}
class AdvancedTypeOne{

}


