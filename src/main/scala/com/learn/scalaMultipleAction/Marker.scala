package com.learn.scalaMultipleAction

/**
  * Created by admin on 2017/7/7.
  */
class Marker(val color: String) {

	override def toString: String = "marker color " + color;
}

object Marker{

	private val markers = Map(
		"red" -> Marker("red"),
		"blue" -> Marker("blue"),
		"green" -> Marker("green")
	)
	def primaryColors = "red, blue, green"

	def apply(color: String): Marker = new Marker(color)

	def getMarker(color: String): Marker = {
		if(primaryColors.contains(color)) markers(color) else null
	}
}
