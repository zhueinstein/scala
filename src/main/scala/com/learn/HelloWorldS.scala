package com.learn

/**
  * Created by admin on 2017/6/15.
  */
object HelloWorldS {
  def main(args: Array[String]): Unit = {
    println("HelloWorld, Scala!")
    var list = List[String]()
    list = "a"::list
    val seq = Seq[String]("c","d")
    seq.foreach(str => list = str::list)
    println(list)
  }
}
