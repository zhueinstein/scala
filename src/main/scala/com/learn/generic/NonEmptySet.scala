package com.learn.generic

/**
  * Created by admin on 2017/6/22.
  */
class NonEmptySet[A <% Ordered[A]](elem: A, left: Set[A], right: Set[A]) extends Set[A]{
    override def incl(x: A): Set[A] =
        if (x > elem) new NonEmptySet(elem, left, right incl x)
        else if(x < elem) new NonEmptySet(elem, left incl x, right)
        else this

    override def contains(x: A): Boolean =
        if(x > elem) right contains x
        else if(x < elem) left contains x
        else true
}
