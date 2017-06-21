package com.learn.intset

/**
  * Created by admin on 2017/6/21.
  */
class NonEmptySet(elem:Int, left: IntSet, right: IntSet) extends IntSet{
  override def incl(x: Int): IntSet = {
    if(x < elem) new NonEmptySet(x, left incl x, right)
    else if(x > elem) new NonEmptySet(x, left, right incl x)
    else this
  }

  override def contains(x: Int): Boolean = {
    if(x < elem) left contains x
    else if(x > elem) right contains x
    else true
  }

  override def isEmpty: Boolean = {
   false
  }

}

object NonEmptySet{
  def apply(elem: Int, left: IntSet, right: IntSet): NonEmptySet = new NonEmptySet(elem, left, right)
}
