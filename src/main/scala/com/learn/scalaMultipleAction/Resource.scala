package com.learn.scalaMultipleAction

import java.io.PrintWriter
import java.util.Date

/**
  * Created by admin on 2017/7/7.
  */
class Resource private(){
	println("Starting transaction ...")

	private def clearUp(){println("Ending tranaction ...")}

	def op1 = println("operation 1")
	def op2 = println("operation 2")
	def op3 = println("operation 3")
}

object Resource{
	def use(codeBlock: Resource => Unit): Unit ={
		val resource = new Resource

		try{
			codeBlock(resource)
		}finally {
			resource.clearUp();
		}
	}

	def main(args: Array[String]): Unit = {
		Resource.use{resource =>
			resource.op1
			resource.op2
			resource.op3
		}

		Resource.writeToFile("d://aout.txt"){
			writer => writer write "Hello Scala !!"
		}

	}

	def writeToFile(fileName:String)(codeBlock: PrintWriter => Unit)={
		val writer = new PrintWriter(fileName)
		try {codeBlock(writer)}finally {writer.close()}
	}


	def log(date:Date, message:String): Unit ={
		println(date + "……" + message);
	}

	val logWithDateBound = log(new Date, _ :String)
	logWithDateBound("m1")
	logWithDateBound("m2")
	logWithDateBound("m3")

}
