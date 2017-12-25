package com.learn.study.variance

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2017/12/19
  */
class Dog(val name: String, val color: String) extends Animal{
	def say = {
		println("汪汪汪")
	}
}

object Dog{
	def apply(name: String, color: String) = new Dog(name, color)
}
