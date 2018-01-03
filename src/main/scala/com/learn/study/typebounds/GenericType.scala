package com.learn.study.typebounds

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2018/1/3
  *     泛型 和 注解
  *             泛型用于指定方法或类可以接受任意类型参数，参数在实际使用时才被确定，
  *             泛型可以有效地增强程序的适用性，使用泛型可以使得类或方法具有更强的通用性。
  *             泛型的典型应用场景是集合及集合中的方法参数，可以说同java一样，scala中泛型无处不在，具体可以查看scala的api
  */
//
object GenericType {

}

/**
  * 1、 泛型类
  */
case class Person[T,S](name: T, age:S)
object PersonDemo{
	def main(args: Array[String]): Unit = {
		val person = Person("lily", 22)
		println(person.name)
	}
}