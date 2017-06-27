package com.learn.beginnerForScala.expr

/**
  * Created by admin on 2017/6/21.
  */
object ExprTest {
    def eval(e:Expr) : Int = e match {
        case Number(n) =>n
        case Sum(l, r) => eval(l) + eval(r)

    }

}
