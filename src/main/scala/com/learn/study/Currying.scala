package com.learn

/**
  * Created by zcx on 2017/6/19.
  */
class Currying {

  def  sum(f: Int => Int)(a: Int , b:Int):Int = {
    if (a > b) 0 else f(a) + sum(f)(a +1 , b)
  }

  def add(a: Int, b: Int) = sum((x : Int) => x)(a, b);
}

object Currying{
  def main(args: Array[String]): Unit = {
    val currying = new Currying;
    println(currying.add(1, 2))
  }
}
