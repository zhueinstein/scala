package com.learn.beginnerForScala.covariant

/**
  * Created by admin on 2017/6/22.
  */
trait Fucntion1[-A, +B] {
    def apply(x: A): B
}
