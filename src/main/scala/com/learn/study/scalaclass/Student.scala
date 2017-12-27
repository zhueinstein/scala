package com.learn.study.scalaclass

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2017/12/27
  *     scala 中没有静态成员变量，可以使用单例对象来直接调用方法、成员
  *     单例对象
  */
// object Student伴生类
class Student(var name: String, age: Int){
	private val sex: String = "女";

	override def toString = s"Student($sex, $name, $age)"
}
/**
  *     从object Student.scala编译后生成两个字节码文件
  *             object Student最终生成了两个类，分别是Student$与Student，它们都是final类型的，
  *             而且Student的构造方法是私有的，通过静态成员域 public static final cn.scala.xtwy.Student$ MODULE$; 对Student$进行引用，
  *              这其实是java语言中单例实现方式。
	单例对象的使用方式同Java语言类引用静态成员是一样的
  * Compiled from "Student.scala"
	public final class com.learn.study.scalaclass.Student {
	  public static void main(java.lang.String[]);
	  public static int uniqueStudentNo();
	}

     Compiled from "Student.scala"
	public final class com.learn.study.scalaclass.Student$ {
	  public static final com.learn.study.scalaclass.Student$ MODULE$; // 单例对象入口
	  private int studentNo;
	  public static {};
	  private int studentNo();
	  private void studentNo_$eq(int);
	  public int uniqueStudentNo();
	  public void main(java.lang.String[]);
	  private com.learn.study.scalaclass.Student$(); // 私有的构造方法
	}
  */

// class Student伴生对象
object Student {
	private var studentNo:Int = 0;
	def uniqueStudentNo: Int ={
		studentNo += 1
		studentNo
	}

	/**
	  * apply方法 ：使用apply方法可以直接使用类名来创建对象，但是这种创建方式避免不了使用new关键字来创建对象
	  *     他的使用机制仍然是使用new的 方式，只不过是在我们自己使用的时候可以避免使用new的操作。
	  * @param name
	  * @param age
	  */
	def apply(name: String, age: Int): Student = new Student(name, age)
	def main(args: Array[String]): Unit = {
		val student = new Student("Lily", 13)
		//     伴生对象用于伴生类只见可以相互访问，包括私有的属性、变量、方法
		println(student.sex)
	}
}
