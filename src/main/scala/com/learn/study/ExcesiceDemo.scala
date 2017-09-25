package com.learn

import sun.nio.cs.ext.DoubleByteEncoder

/**
  * Created by admin on 2017/6/20.
  */
class ExcesiceDemo {

  def sum(f:Int => Int)(a:Int, b:Int):Int ={
    if(a >b) 0 else f(a) + sum(f)(a +1 ,b)
  }

  def product(f: Int => Int)(a: Int, b: Int):Double = {
    if(a > b) 1 else f(a) * product(f)(a + 1, b)
  }

  def factorial(n: Int):Int={
    if(n == 0) 1 else factorial(n -1) * n
  }

  def sumAndPut(f: Int => Int)(f2:(Int, Int) =>Int)(a:Int, b:Int):Int={
    if(a >b) 0 else f2(f(a), a+1)
  }


  val tolerance = 0.000000000000000000000000000000000001;
  def isGoodEnough(x: Double, y:Double):Boolean =
    Math.abs((x -y)/y) < tolerance
  def fixedPoint(f:Double => Double)(firstGuess:Double):Double = {
    def iterate(guess: Double): Double ={
      var  next = f(guess);
      println(next)
      if(isGoodEnough(guess, next)) next
      else iterate(next)
    }

    iterate(firstGuess)
  }


  def sqrt(x:Double) = fixedPoint(y => (y + x/y)/2)(1.0)
}

object ExcesiceDemo extends App{
  def apply: ExcesiceDemo = new ExcesiceDemo()

  println(ExcesiceDemo.apply.product(x => x * 2)(1, 2))

  println(ExcesiceDemo.apply.factorial(3))

  println(ExcesiceDemo.apply.product(ExcesiceDemo.apply.factorial)(1, 3))

  println(ExcesiceDemo.apply.sumAndPut(x=>x*x)((y, z) => y + z)(1, 30))
  ExcesiceDemo.apply.sqrt(2.0);
}
