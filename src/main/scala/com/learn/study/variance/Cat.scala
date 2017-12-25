package com.learn.study.variance

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2017/12/19
  */
class Cat(name: String, color: String) extends Animal{


	def say = {
		println("喵喵喵")
	}
}
object Cat{
	def apply(name: String, color: String): Cat = new Cat(name, color)
}
