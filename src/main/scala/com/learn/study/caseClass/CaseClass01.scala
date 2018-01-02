package com.learn.study.caseClass

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2018/1/2
  *     样例类
  *             可以用于模式匹配
  *      当一个类被声名为case class的时候，scala会帮助我们做下面几件事情：
	1 构造器中的参数如果不被声明为var的话，它默认的话是val类型的，但一般不推荐将构造器中的参数声明为var
	2 自动创建伴生对象，同时在里面给我们实现子apply方法，使得我们在使用的时候可以不直接显示地new对象
	3 伴生对象中同样会帮我们实现unapply方法，从而可以将case class应用于模式匹配，关于unapply方法我们在后面的“提取器”那一节会重点讲解
	4 实现自己的toString、hashCode、copy、equals方法
  */
// 抽象Person
abstract class Person

case class Student(var name: String, age: Int, studentNo: Int) extends Person
case class Teacher(name: String, age:Int, teacherNo: Int) extends Person
case class NoBody(name: String) extends Person

// 多个参数的case class
case class SchoolClass(description: String, person:Person*)

// 自己定义的unapply方法
object GiveNames{
	def unapplySeq(name: String): Option[Seq[String]] = {
		val names = name.split(" ")
		if(names.forall(_.isEmpty)) None
		else Some(names)
	}
}
class GiveNames(name: String, age: Int) extends Person
object CaseClass01 extends App{
	val p: Person = new Student("WeFon", 28, 1)
	p match {
		case Student(name, _, _) => println(s"$name is the student name")
		case Teacher(name, _,_) => println(s"$name is the teacher name")
		case NoBody(name) => println(s"$name is noBody")
	}

	val name = "WeFon";
	name match{
		case GiveNames(name, _*) => println(s"The Match is Student and name is $name")
		case _ => println(s"Nobody is match")
	}
	val student:Student = new Student("WeFon", 29, 1)

	var student2 = student.copy()
	// copy方法是深度复制, 不会改变原有的对象
	student2.name = "WeFon2"
	println(student)
	println(student2)

	val schoolClass: SchoolClass = new SchoolClass("计算机精英教学班", Teacher("WeFon", 29, 1), Student("Tom", 18, 1), Student("Lilly", 20, 2))
	schoolClass match {
		case SchoolClass(_, _, Student(name, _, _), _) => println(s"$name ")
		case _ => println("Nobody")
	}
}
