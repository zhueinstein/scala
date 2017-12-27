package com.learn.study.scalaclass

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2017/12/27
  *     抽象类： 抽象类是一种不能被实例化的类，抽象类中定义了若干不能完整定义的方法，这些方法由其子类来扩展定义自己的实现
  */

/**
  *
		Compiled from "Animal.scala"
		public abstract class com.learn.study.scalaclass.Animal {
		  public abstract void eat();
		  public com.learn.study.scalaclass.Animal();
		}
  */
abstract  class Animal {
	// 抽象方法
	def eat: Unit
	// 抽象变量（域）
	// 一般类中定义的变量需要初始化，抽象类中没有这要求
	var height: Int
}

// Dog 继承Animal 对eat方法进行了实现， 对height字段进行了初始化
class Dog extends Animal{
	override def eat: Unit = {
		println(" eat many food")
	}

	override var height: Int = 175
}
