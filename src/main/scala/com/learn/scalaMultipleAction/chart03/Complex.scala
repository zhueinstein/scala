package com.learn.scalaMultipleAction.chart03

/**
  * Created by admin on 2017/7/6.
  */
class Complex(val real: Int, val magicNum: Int) {
	def +(ads: Complex) :Complex ={
		new Complex(real + ads.real, magicNum + ads.magicNum)
	}

	override def toString: String = {
		real + "+" + magicNum + "i"
	}
}

object Complex extends App{
	def apply(real: Int, magicNum: Int): Complex = new Complex(real, magicNum)
	val ad = Complex.apply(1, 4) + Complex.apply(2, 4)
	println(ad.toString)
}
