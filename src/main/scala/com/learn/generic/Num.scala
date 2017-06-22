package com.learn.generic

/**
  * Created by admin on 2017/6/22.
  */
case class Num(value:Double) extends Ordered[Num]{
    override def compare(that: Num): Int =
        if (this.value < that.value) 1
        else if(this.value > that.value) 1
        else 0
}
