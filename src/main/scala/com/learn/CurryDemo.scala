package com.learn

/**
  * Created by admin on 2017/6/20.
  */
class CurryDemo {

    def commonOp[T](list: List[T])(f: List[T] => List[T]) : Option[List[T]] = {
        list match {
            case h :: t =>Some(f(t))
            case _ => None
        }
    }

  def sum(f:Int => Int)(a: Int, b: Int):Int ={
    if(a > b) 0 else f(a) + sum(f)(a + 1, b)
  }

  def sumE(f:Int => Double)( a: Int, b:Int):Double={
    def iter(a:Int, result:Int):Double ={
        if(a <= b) f(result) + a
          else
          iter(a+ 1, result);
    }
    iter(a, b)
  }
}

object CurryDemo extends App{
    val list = List(1,2,3,4,5)
    val curryDemo = new CurryDemo
  println(curryDemo.commonOp(list)((list: List[Int]) => list))
  def adder = (n: Int) => (m: Int) =>(list:List[Int]) => m:: n :: list
  println(curryDemo.commonOp(list)((list:List[Int]) => 100 :: list))
  val ads = (x: Int)=>(result:Double) => x + result;
  println(curryDemo.sumE(x => x)(1, 2))
}
