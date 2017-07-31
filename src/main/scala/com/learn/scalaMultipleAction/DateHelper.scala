package com.learn.scalaMultipleAction

import java.util._

/**
  * Created by admin on 2017/7/10.
  */
class DateHelper(number: Int) {
	def days(when: String): Date = {
		val date = Calendar.getInstance()
		when match {
			case "ago" => date.add(Calendar.DAY_OF_MONTH, -number)
			case "from_now" => date.add(Calendar.DAY_OF_MONTH, number)
			case "years_ago" => date.add(Calendar.YEAR, -number)
			case _ => Calendar.getInstance()
		}
		date.getTime
	}
	def add(adNum: Int): Int ={
		number + adNum
	}
}
object DateHelper{
	implicit def convertIsnt2DateHelper(number: Int) = new DateHelper(number)

	val ago = "ago"
	val from_now = "from_now"
	val years_ago = "years_ago"
}