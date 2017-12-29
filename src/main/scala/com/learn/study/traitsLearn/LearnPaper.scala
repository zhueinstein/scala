package com.learn.study.traitsLearn

import java.io.PrintWriter

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2017/12/29
  */
object LearnPaper {
	/**     1、scala类层次结构
		  *     从类层次结构图中可以看到，处于继承层次最顶层的是Any类，它是scala继承的根类，scala中所有的类都是它的子类
		  *	Any类中定义了下面几个方法:
		  *     ==与!=被声明为final，它们不能被子类重写
			final def ==(that: Any): Boolean
			final def !=(that: Any): Boolean
			def equals(that: Any): Boolean
			def hashCode: Int
			def toString: String
		        Any类中公有五个方法， 其中 == 和 ！= 被声明为final 类型， 其方法不能被子类重写 ，事实上 == 方法是通过equals方法来实现的
		                ！= 是通过 ！equals方法来实现的， 如果想改变 == 和 != 方法， 可以对equals重写

		  根类Any有两个子类，它们分别是AnyVal和AnyRef，其中AnyVal是所有scala内置的值类型（ Byte, Short, Char, Int, Long, Float, Double, Boolean, Unit.）的父类，
			其中 Byte, Short, Char, Int, Long, Float, Double, Boolean与java中的byte,short,char,int,long,float,double,boolean原生类型对应，而Unit对应java中的void类型，
			由于（ Byte, Short, Char, Int, Long, Float, Double, Boolean, Unit）继承AnyVal，而AnyVal又继承Any，因此它们也可以调用toString等方法。
		  特别的，() 可以作为Unit的实例

		  AnyRef是Any的另外一个子类，它是scala中所有非值类型的父类，对应Java.lang.Object类（可以看作是java.lang.Object类的别名），
			也即它是所有引用类型的父类（除值类型外）。
			那为什么不直接Java.lang.Object作为scala非值引用类型的父类呢？
				这是因为Scala还可以运行在其它平台上如.Net，所以它使用了AnyRef这个类，在JVM上它对应的是java.lang.Object，而对于其它平台有不同的实现。
	  2、Scala中原生类型的实现方式解析
		scala采用与java相同原生类型存储方式，由于性能方面及与java进行操作方面的考虑，scala对于原生类型的基本操作如加减乘除操作与java是一样的，当需要遇到其他方法调用时，则使用java的原生类型封装类来表示，
		如Int类型对应于java.lang.Integer类型，这种转换对于我们使用者来说是透明的。
	  3、Noting Null类型解析
	        Null类型是所有AnyRef类型的子类型，也即它处于AnyRef类的底层，对应java中的null引用。
		而Nothing是scala类中所有类的子类，它处于scala类的最底层
	  */

	def main(args: Array[String]): Unit = {
		//() 可以作为Unit的实例, 也可以调用Any的方法
		println(().isInstanceOf[Unit])
		println(().toString)

		//scala中的==操作它不区分你是原生类型还是引用类型，如果想区分引用类型的相等，使用AnyRef的eq ne 方法
		println( "abc" == "abc")
		val s1 = new String("abc")
		val s2 = new String("abc")
		println(s1 == s2) // true
		println(s1 equals  s2) //true
		println(s1.eq(s2))  //false
		println(divide(1,0))



	}

	// //Nothing这个类一般用于指示程序返回非正常结果，利用Nothing作为返回值可以增加程序的灵活性。例如：
	def error(msg: String): Nothing = {
		throw new RuntimeException(msg)
	}
	def divide(num1: Double, num2: Double): Double ={
		if(num2 != 0){
			num1/num2
		}else{
			error("can't divide by zero")
		}
	}
}

/**
  * 4、Traits
  *     scala和Java一样，采取了很强的限制策略，在Java语言中，只允许有一个超类，该类可以实现许多许多接口
  *             但是接口中本身有局限性，只能包含抽象方法，不能包含字段、具体方法，Scala语言使用Traits解决了
  *             该限制，Traits可以包含抽象方法、字段、具体方法
  *
  *
  *
  */
// trait 演示
trait DAO{
	//定义一个抽象方法，注意不需要加abstract
	//加了abstract反而会报错
	// 带具体实现的trait，在编译之后会生成两个字节码文件，其是通过JJava中的抽象类来实现的
	def delete(id:String):Boolean
	def add(o:Any):Boolean
	def update(o:Any):Int
	def query(id:String):List[Any]
	def concreteness:Unit={
		println("具体实现")
	}
}

class DAOImpl extends DAO{
	override def delete(id: String): Boolean = true

	override def add(o: Any): Boolean = true

	override def update(o: Any): Int = 1

	override def query(id: String): List[Any] = List.empty


}

object TraitsDemo extends App{
	val dAOImpl:DAOImpl = new DAOImpl
	println(dAOImpl.add(1))

}

/**
        1、trait构造顺序
                对于不存在具体实现和字段，trait会生成Java的接口
                有具体实现的trait，通过Java抽象类来实现，它有着scala语言自己的实现方式。
		因此，对于trait它也有自己的构造器，trait的构造器由字段的初始化和其它trait体中的语句构成，下面是其代码演示：


                通过上述不难发现，在创建匿名类对象时，先调用的是Logger类的构造器，然后调用的是FileLogger的构造器。实际上构造器是按以下顺序执行的：
			1. 如果有超类，则先调用超类的构造器
			2. 如果有父trait，它会按照继承层次先调用父trait的构造器
			2. 如果有多个父trait，则按顺序从左到右执行
			3. 所有父类构造器和父trait被构造完之后，才会构造本类
        2、trait有自己的构造器，但是他不能带参数，除此之外与普通的scala类无区别
        3、提前定义与懒加载
        4、根据2 trait业已扩展其他类
  */
trait Logger{
	println("Logger")
	def log(msg: String): Unit
}

trait FileLogger extends Logger{
	println("FileLogger")
	val fileName: String
	// 懒加载
	//lazy方式定义fileOutput只有当真正被使用时才被初始化，例子中，当调用 s.log(“predifined variable “)时，fileOutput才被初始化，此时fileName已经被赋值了
	lazy val printWrite = new PrintWriter(fileName: String)
//	printWrite.write("#")
	def log(msg: String):Unit ={
		printWrite.write(msg)
		printWrite.flush()
	}
}

class Person
class Student extends Person with FileLogger{
	 val fileName: String = "/Users/zcx/file1.log"
}

object TraitsDemo1 extends App{
	//1 提前定义
	//	提前定义是指在常规构造之前将变量初始化, 否则会报空指针异常
	/*val student = new {
		override val fileName = "/Users/zcx/file1.log"
	} with Student*/
	val student = new Student
	student.log("name: lily")
}

/**
       *** Self Type
  *     自身类型
  *
  */

class A{
	// self 定义了this的别名， 他是type self的一种特殊形式
	// self 不是关键字，可以是任何名称
	self =>
	val x = 2
	def foo = self.x + this.x
}
// 内部类中使用
class OutClass{
	// 定义了this的别名
	outer =>
	val x = 2
	class InnerClass{
		// 用outer表示外部类，相当于OuterClass.this
		def y = outer.x
	}
}

//而下面的代码则定义了自身类型self type，它不是前面别名的用途，
trait X{

}
class B{
	// self:B 要求B在实例化或定义子类时，必须混入指定的X的类型，这个X类型也可以指定为当前的类型
	selfss:X =>
}

/**
  *     自身类型的存在相当于使类变得"抽象"了
  *     它假设当前对象this也符合指定的类型，因为自身类型this:X=>的存在，当前类构造实例时也必须满足X类型
  */
trait XX{
	def foo()
}
class C{
	self: XX =>
}
class D extends C with XX{
	override def foo(): Unit = {
		println("构造C的实例或者子类时必须实现指定XX的类型")
	}
}

object A extends  App{
	val a = new A
	println(a.foo)
	val d = new D
	d.foo()
}