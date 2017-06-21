package com.learn

import com.learn.intset.IntSet

/**
  * Created by admin on 2017/6/21.
  */
trait InSet {
    def incl(x:Int) :IntSet
    def contains(x:Int) : Boolean
}
