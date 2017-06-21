package com.learn.intset

/**
  * Created by admin on 2017/6/21.
  */
class EmptySet extends IntSet{
   def incl(x: Int): IntSet =
     new NonEmptySet(x, new EmptySet, new EmptySet)

   def contains(x: Int): Boolean = false

  override def isEmpty: Boolean = true

}


object EmptySet{
  def apply: EmptySet = new EmptySet()
}