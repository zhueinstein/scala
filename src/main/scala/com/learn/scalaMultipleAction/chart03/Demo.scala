package com.learn.scalaMultipleAction.chart03

import java.util._
/**
  * Created by admin on 2017/7/6.
  */
object Demo extends App{
	for(i <- 1 to 10){ // to 有上界10 和下届 1
		print(i + " ")
	}
	println()
	for(i <- 1 until  10){ // until 排除了上界 10
		print(i + " ")
	}
	println()

	1 to 10 foreach(i => print(i + " "))
	println()

	val str =
		""" I'm Ok,
		  and you?
		""".stripMargin
	println(str)

//	var list1 = List[Int]
//	var list2 = List[Any]

	var ref1: Int = 1
	var ref2: Any = null

	ref2 = ref1

//	list2 = list1
//	val numbers = List(1,3,4,5,6,3,32,5,1,4,23,43,5454,5454,545,0)

	def max(values: Int*) = values.foldLeft(-1){Math.max}

//	max(numbers: _*)
}
