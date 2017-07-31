package com.learn.scalaMultipleAction

/**
  * Created by admin on 2017/7/10.
  */
trait CreditCheck extends Check{
	override def check(): String = "CreditCheck……" + super.check()
}
