package com.learn.scalaMultipleAction

/**
  * Created by admin on 2017/7/10.
  */
trait ProfanityWriter extends Writer{
	abstract override def writeMessage(message: String): Unit = super.writeMessage(message.replaceAll("stupid", "s____"))
}