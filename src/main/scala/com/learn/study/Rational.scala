package com.learn

/**
  * Created by admin on 2017/6/21.
  */
class Rational(n:Int, d:Int) extends AnyRef{
    private def gcd(x:Int, y:Int):Int = {
      if(x == 0) y
      else if(x < 0) gcd(-x, y)
      else if(y < 0) -gcd(x, -y)
      else gcd(y%x, x)
    }
    val g = gcd(n, d)

  val numer:Int = n/g
  val denom:Int = d/g

  def +(that: Rational)={
    new Rational(numer * that.denom + denom * that.numer, denom * that.denom)
  }

  def -(that: Rational)={
    new Rational(numer* that.denom - denom * that.numer, denom * that.denom)
  }

  def *(that: Rational)={
    new Rational(numer * that.numer, denom * that.denom)
  }
  def /(that:Rational)={
    new Rational(numer * that.denom, denom * that.numer)
  }


  // 无参数函数，调用时可以省略（）
  def square = new Rational(numer * numer, denom* denom)
  override def toString: String = numer + "/" + denom
}

object Rational extends App{
  def apply(n: Int, d: Int): Rational = new Rational(n, d)

  println((Rational.apply(3, 3)*(Rational.apply(4, 5))))

  println(Rational.apply(2, 5).square)
}
