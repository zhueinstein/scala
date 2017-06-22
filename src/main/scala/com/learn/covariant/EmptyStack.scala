package com.learn.covariant

import scala.runtime.Nothing$

/**
  * Created by admin on 2017/6/22.
  */
object EmptyStack extends Stack[Nothing]{
    override def isEmpty: Boolean = true

    override def top: Nothing = ???

    override def pop: Stack[Nothing] = ???
}
