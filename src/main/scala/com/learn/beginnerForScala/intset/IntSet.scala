package com.learn.intset

/**
  * Created by admin on 2017/6/21.
  */
abstract class IntSet {
  def incl(x:Int): IntSet;
  def contains(x:Int):Boolean
  def isEmpty: Boolean
}
