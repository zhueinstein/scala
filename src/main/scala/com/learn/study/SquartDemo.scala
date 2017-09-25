package com.learn

/**
  * Created by admin on 2017/6/16.
  */
class SquartDemo {

  def squrt(x: Double) ={
    def squartIter(guess: Double): Double ={
      if(isGoodEnough(guess)) guess
      else
        squartIter(improve(guess))
    }

    def isGoodEnough(d: Double) ={
      Math.abs(Math.pow(d, 2) -x) < 0.0001
    }

    def improve(d: Double)={
      (d + x/d)/2
    }
    squartIter(1.0)
  }

  def gcd(a: Int, b: Int):Int = {
    if(b == 0) a else gcd(b, a % b)
  }

  def factorial(x: Int, r: Int): Int={
    if(x == 0) r else factorial(x-1, x * r)
  }

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    if(a > b) 0 else f(a) + sum(f, a + 1, b)
  }

  def numAdd(a: Int, b: Int) = sum((x: Int) =>x, a, b)

  def numQAdd(a:Int, b:Int) = sum((x: Int) => x * x, a, b)
}

object SquartDemo{
  def main(args: Array[String]): Unit = {
    val squartDemo = new SquartDemo();
    println(squartDemo.squrt(4))
//    println(Math.pow(4,2))

    println(squartDemo.gcd(49, 140))
    println(squartDemo.factorial(3, 1))

     println (s"squartDemo = ${squartDemo.numAdd(1,100)}")
    println(squartDemo.numQAdd(1, 3))
    println()
  }

}
