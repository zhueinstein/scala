package com.learn.beginnerForScala.generic

/**
  * Created by admin on 2017/6/22.
  */
object GenericTest extends App{
    val s = new EmptySet[Num].incl(Num(1.0)).incl(Num(2.0))
    println(s.contains(Num(1.0)))

    val in = new EmptySet[Int].incl(1)
}
