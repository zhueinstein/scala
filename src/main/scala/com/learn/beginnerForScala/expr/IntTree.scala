package com.learn.expr

/**
  * Created by admin on 2017/6/21.
  */
abstract class IntTree {

    def contains(t: IntTree,v:Int):Boolean = t match {
            case EmptyTree => false
            case Node(ele, left, right) => {
                if(v > ele) right contains(right, v) else if(v < ele) left contains(left, v) else true
            }
        }
    def insert(t: IntTree, v:Int):IntTree = t match {
        case EmptyTree => new Node(v, EmptyTree, EmptyTree)
        case Node(elem, left, right) => {
            if(v < elem) new Node(elem,  left insert(left, v), right)
            if(v > elem) new Node(elem, left, right insert(right, v))
            else this
        }
    }


}
    case object EmptyTree extends IntTree

    case class Node(elem: Int, left: IntTree, right: IntTree) extends IntTree

