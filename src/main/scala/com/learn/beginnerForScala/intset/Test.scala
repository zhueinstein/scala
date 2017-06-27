package com.learn.beginnerForScala.intset

/**
  * Created by admin on 2017/6/21.
  */
object Test extends App{

  val left = EmptySet.apply
  var right = EmptySet.apply
  val  nonEmptySet = NonEmptySet.apply(9, left, right)
  val newSet =  nonEmptySet.incl(1).incl(2).incl(3).incl(33)



//  val ssset = NonEmptySet.apply(23, nonEmptySet, right)
//  val newsss = ssset.incl(3)
//  println(newsss.contains(3))
}
