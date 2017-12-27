package com.learn.study.access

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2017/12/27
  *     访问控制
  *     Java语言中，主要通过public、private、protected、及默认控制来实现包中类成员的访问控制，
  *             当定义一个类，如果成员不添加任何访问控制符，表示该成员在类的包内可见。
  *     Scala中没有public关键字，仅有private和protected访问控制符
  *             当定义一个类时，如果类成员没有修饰符时，他的访问权限就是public
  *
  *        访问规则表
  *        修饰符                                         访问范围
  *        无任何修饰符                               任何地方都可以访问
  *        private[scala]                              在定义的类中、scala包、scala子包中中可以访问
  *        private[this]                                只能在该类中访问，伴生对象中也不能访问
  *        private                                         只能在类和类的伴生对象中使用，不能在其他地方使用
  *        protected[scala]                              在定义的类及伴生对象中可以使用，scala包及子包中可以使用
  *        protected[this]                              在定义的类中可以使用，伴生对象中也不可以使用
  *        protected                                    在定义的类及伴生对象中可以使用，其他地方不可以使用
  *
  */

// 1、private 和Java一样，带有该关键字的成员仅能在定义它的类或对象中使用，在外部不可用
class Student(var name: String, var age: Int) {
	private val sex: Int = 0
	// 内部类
	class Course(val cName: String){
		// 可以直接访问外部类的私有成员
		def getSex(student: Student) = student.sex
	}
}
class ClassRoom{
	// 错误，sex是私有的
//	def getStudentSex(student: Student) = student.sex
}
// 2、protected修饰的成员 Java中可以被该类、子类、同一包下的类使用 ，scala 中 只能被该类、子类使用
class SuperClass{
	def f() = println("……")
}
class SubClass extends SuperClass{
	f()
}

class OtherClass{
	// 报错
	//f();
}
//3、无修饰符成员 同Java的public, 可以在任何位置使用

//4、保护范围
	// 在Scala中提供了更为灵活的访问控制方法，private、protected修饰符除了可以修饰成员外，还可以以private[X]、protected[X]
	// 的方式进行更为灵活的访问控制，这种访问控制的意思是将private、protected限定到X，X可以是包、类、单例对象
package cn{
	class UtilsTest{
		// 编译不通过，因为Utils使用private[scala]修饰，只能在scala及其子包中使用
//		Utils.toString()
	}
	package scala{
		private[scala] object Utils{
			def toString(x: String): Unit ={
				println(x)
			}
			import com.learn.study.access.cn.scala.wee.Teacher
			def getTeacher(): Teacher = new Teacher("Jack");
		}


		package wee{
			class Teacher(var name: String){
				def printName: Unit ={
					println(name)
				}
			}
		}
	}
}
	// private[this] ,限定只有该类的对象才可以使用，称这种成员为对象私有成员
class Teachers(var name: String){
	// private[this] ,限定只有该类的对象才可以使用，称这种成员为对象私有成员, 伴生对象也不能访问
	private[this] def printName(tName: String="") = println(tName)
		private[this] val ttName:String = "teacher";
	// private ，限定 类及伴生对象可以访问
	private def printNamePrivate(tName: String = "") = println(tName + ttName)


}
object Teachers{
	def apply(name: String): Teachers = new Teachers(name)

	// private[this]限定的成员，伴生对象也不能使用
	//def printName = new Teacher("David").printName()
	// private ，限定 类及伴生对象可以访问
	def printtName = Teachers("ddd").printNamePrivate("ss")

	def main(args: Array[String]): Unit = {
		printtName
	}
}