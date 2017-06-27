package com.learn.beginnerForScala.generic

/**
  * Created by admin on 2017/6/22.
  */
class EmptySet [A <% Ordered[A]] extends Set[A]{
    override def incl(x: A): Set[A] = new NonEmptySet[A](x, new EmptySet[A], new EmptySet[A])

    override def contains(x: A): Boolean = false
}
