package com.learn.study.scalaclass

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2017/12/25
  */
object ClassTestDemo extends App{
	val person = new Person("Weefun")
	println(person)
	// 对于将主构造器设置为私有的， 在编译时如果不是在本类中调用会报错
	//val peerson3 = new Person3("tom", 22)
	val person3 = Person3("Jerry", 23)
	println(person3)
	val person3_1 = new Person3_11("adc")
	println(person3_1)
	val person4 = new Person4();
	println(person4)


	// 单例对象
	println(Student.uniqueStudentNo)
	val student1 = new Student("WeeFun", 22)
	// 直接使用类名来创建对象，时间上是调用apply方法，这种好处是可以避免自己手动使用new操作创建对象
	val student2 = Student("Lucy", 14)
	println(student2.name)
//	println(student2.age) // 错误
}
