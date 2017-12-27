package com.learn.study.scalaclass

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2017/12/25
  *  主构造器参数                                                        生成的成员                                                                  方             法
  *     name: String                                    对象私有的成员（或者 如果没有使用到name， 不会生成成员）           无
  *     private val/var name: String             私有的成员                                                                                    私有的getter和getter方法
  *     val/var name: String                         私有的成员                                                                                    公有的getter和getter方法
  *     //@BeanProperty name: String         公有的成员                                                                                     公有的getter和getter方法
  *
  *     类名后面紧跟private关键字可以将主构建器设为私有，不允许外部使用
  */
//当主构造器的参数不用var或val修饰的时候，主构造器被调用过，参数会生成类的私有val成员，只会产生私有的getter方法， 不会生成set方法
/**
  *      public class com.learn.study.scalaclass.Person {
	  private final java.lang.String name;
	  private final int age;
	  public static int $lessinit$greater$default$2();
	  private int age();
	  public java.lang.String toString();
	  public com.learn.study.scalaclass.Person(java.lang.String, int);
	}
  */
class Person( name: String, private val age: Int = 28) {
	override def toString = s"Person($name, $age)"
}
// 主构造器的参数使用val var 修饰的，参数会类的val 和 var成员， val 不会生成set方法 ,只生成get方法，var生成get set方法
/**
  *
		javap -private Person1
		警告: 文件 ./Person1.class 不包含类 Person1
		Compiled from "Person.scala"
		public class com.learn.study.scalaclass.Person1 {
		  private final java.lang.String name;
		  private int age;
		  public static int $lessinit$greater$default$2();
		  public java.lang.String name();
		  public int age();
		  public void age_$eq(int);
		  public java.lang.String toString();
		  public com.learn.study.scalaclass.Person1(java.lang.String, int);
		}
  */
class Person1( val name: String, var age: Int = 28) {
	override def toString = s"Person($name, $age)"
}

/**  当主构造器的参数不用var或val修饰的时候，如果主构造器没有被调用过，不会生成任何参数的成员和getter setter方法
   *       Compiled from "Person.scala"
	 public class com.learn.study.scalaclass.Person2 {
	  public com.learn.study.scalaclass.Person2(java.lang.String, int);
	}
  */
class Person2(name: String, age: Int){

}

//类名后面紧跟private关键字可以将主构建器设为私有，不允许外部使用
class Person3 private(name: String, age: Int){
	override def toString = s"Person3($name,$age)"
}

object Person3{
	def apply(name: String, age: Int): Person3 = new Person3(name, age)
}
// 如果将主构造器禁用掉， 就必须使用辅助构造器来创建对象
	// 辅助构造器有两个特点
		//1、辅助构造器名称为this
		//2 、辅助构造器必须首先调用主构造器或者其他定义好的辅助构造器

class Person3_11 private(var name: String, var age: Int){
	def this(name: String, age: Int){
		this
		this.name = name

	}
	override def toString = s"Person3_1($name,$age)"
}

// 只有辅助构造器的类
class Person4{
	private var name: String = "WeeFun";
	private var age: Int = 120;

	def this(name: String){
		this
		this.name = name
	}

	def this(name: String, age: Int){
		this
		this.name = name
		this.age = age
	}


	override def toString = s"Person4($name, $age)"
}