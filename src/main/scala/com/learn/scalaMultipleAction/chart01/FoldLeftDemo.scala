package com.learn.scalaMultipleAction.chart01

/**
  * Created by admin on 2017/7/6.
  */
class FoldLeftDemo {



}

object FoldLeftDemo extends App{
	val list = List(55,20, 10, 22, 33, 25)
	println(Integer.MIN_VALUE)
	// foldLeft(default value) 给定一个初始值，跟集合中的每一个元素进行对比
	println(list.foldLeft(100){Math.max})}//println(list.foldLeft(100){Math.max(_, _)})}
