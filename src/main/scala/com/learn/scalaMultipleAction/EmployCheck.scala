package com.learn.scalaMultipleAction

/**
  * Created by admin on 2017/7/10.
  */
trait EmployCheck extends Check{
	override def check(): String = "EmployCheck" + super.check()
}
