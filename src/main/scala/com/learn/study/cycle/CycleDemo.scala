package com.learn.study.cycle

/**
  * Created by zcx on 2017/9/17.
  */
object CycleDemo {
	def main(args: Array[String]): Unit = {
		/*for(i <- 1 to 10){
			println(i)
			if(i == 5){
				return
			}
		}*/

		val chars = for(c <- "Hello"; i <- 0 to 1 )  yield  (c + i).toChar
		println(chars)
	}
}
