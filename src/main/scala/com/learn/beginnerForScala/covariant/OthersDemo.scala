package com.learn.beginnerForScala.covariant

/**
  * Created by admin on 2017/6/22.
  */
class OthersDemo {
    def divmod(x: Int, y: Int) = new Tuple2[Int, Int](x/y, x%y)

}
object OthersDemo extends App{
    def apply() = new OthersDemo

    println(OthersDemo.apply().divmod(1, 2))
    val  f:(AnyRef => Int) = x => x.hashCode()
    val g:(String => Int) = f
    println(g("2"))


}