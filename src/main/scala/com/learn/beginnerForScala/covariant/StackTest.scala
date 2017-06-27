package com.learn.beginnerForScala.covariant

/**
  * Created by admin on 2017/6/22.
  */
object StackTest extends App{
    val stack = EmptyStack.push("aa")
    println(stack.top)
}
