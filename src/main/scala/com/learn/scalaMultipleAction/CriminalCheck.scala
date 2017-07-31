package com.learn.scalaMultipleAction

/**
  * Created by admin on 2017/7/10.
  */
trait CriminalCheck extends Check{
	override def check(): String = "CriminalCheck " + super.check()
}
