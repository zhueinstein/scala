package com.learn.covariant

/**
  * 协变
  * Created by admin on 2017/6/22.
  */
abstract class Stack[+A] {
    def push[B >: A](x: B):Stack[B] = new NonEmptyStack[B](x, this);
    def isEmpty:Boolean
    def top: A
    def pop:Stack[A]
}
