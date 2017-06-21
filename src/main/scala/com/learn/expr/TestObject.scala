package com.learn.expr

/**
  * Created by admin on 2017/6/21.
  */
object TestObject extends App{
    val tree = new Node(8, EmptyTree, EmptyTree)
    val t1 = tree.insert(tree, 8)
    println(t1.contains(t1, 8))
}
