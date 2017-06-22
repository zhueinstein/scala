package com.learn.generic

/** 泛型参数边界
  * Created by admin on 2017/6/22.
  */
abstract class Set[A <% Ordered[A]] {
    def incl(x: A): Set[A]
    def contains(x: A): Boolean
}
