package com.learn.beginnerForScala.expr

/**
  * Created by admin on 2017/6/21.
  */
abstract class Expr
  case class Number(n:Int) extends Expr
  case class Sum(e1:Expr, e2:Expr) extends Expr

