package com.learn.scalaMultipleAction

/**
  * Created by admin on 2017/7/10.
  */
class StringWriterDelagate extends Writer{
	val writer = new java.io.StringWriter()
	override def writeMessage(message: String): Unit = writer.write(message)

	override def toString: String = writer.toString
}
