package com.learn.scalaMultipleAction

/**
  * Created by admin on 2017/7/10.
  */
trait UpperCaseWriter extends Writer{
	abstract override def writeMessage(message: String) = super.writeMessage(message.toUpperCase)
}


