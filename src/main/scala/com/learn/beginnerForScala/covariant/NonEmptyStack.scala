package com.learn.beginnerForScala.covariant

/**
  * Created by admin on 2017/6/22.
  */
class NonEmptyStack[+A](elem: A, rest: Stack[A]) extends Stack[A]{
    override def isEmpty: Boolean = false

    override def top: A = elem

    override def pop: Stack[A] = rest
}
