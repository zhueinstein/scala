package com.learn.beginnerForScala.curry

/**
  * Created by admin on 2017/6/27.
  */
class PartFucDemo

case class Email(subject: String,
                 text: String,
                 sender: String,
                 recipient: String)

case class User(name: String)

object PartFucDemo{
    type EmailFilter = Email => Boolean

    type IntPairPred = (Int, Int) => Boolean

    def sizeConstraint(pred: IntPairPred, n :Int, email: Email)= pred(email.text.size, n)
    val sizeConstraintFn:(IntPairPred, Int, Email) =>Boolean = sizeConstraint _

    val gt: IntPairPred = _ > _
    val ge: IntPairPred = _ >= _
    val lt: IntPairPred = _ < _
    val le: IntPairPred = _ >= _
    val eq: IntPairPred = _ == _

    val minimumSize:(Int, Email) => Boolean = sizeConstraint(ge, _:Int,_: Email)
    val maximumSize: (Int, Email) => Boolean = sizeConstraint(le, _:Int, _:Email)

    val constr20: (IntPairPred, Email) => Boolean =
        sizeConstraint(_: IntPairPred, 20, _:Email)

    val constr30:(IntPairPred, Email) => Boolean = sizeConstraint(_:IntPairPred, 30, _:Email)
    def sizeConstraintCurry(pred: IntPairPred)(n:Int)(email:Email):Boolean = pred(email.text.size, n)
//    val sizeConstraintCurryFn: IntPairPred => Int =>Email => Boolean = sizeConstraint _

    val minSize: Int => Email => Boolean = sizeConstraintCurry(ge)
    val maxSize: Int => Email => Boolean = sizeConstraintCurry(le)

    val min20:Email => Boolean = minSize(20)
    val max30:Email =>Boolean = maxSize(30)

    val min20_1: Email => Boolean = sizeConstraintCurry(ge)(20)
    val max20_1: Email => Boolean = sizeConstraintCurry(le)(20)

    val sum:(Int, Int) => Int = _ + _
    val sumCurried: Int => Int =>Int = sum.curried
    def main(args: Array[String]): Unit = {






    }

}
