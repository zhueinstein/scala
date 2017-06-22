package com.learn.newGuider.extractor

/**
  * Created by admin on 2017/6/22.
  */
object ExtractorTest {

    def main(args: Array[String]): Unit = {
        val user = new FreeUser("steinLess", 100, 0.9d)
       user match {
            case freeUser@PremiumCandidate() => println(s"$freeUser 升级为付费客户")
            case PreminumUser(name) =>println(s"Welcome back, $name")
            case _ => println("None extractor")
        }

        val xs = 58 #::45 #:: 93 #:: Stream.empty
        xs match {
            case first #:: second #:: _ => println(first - second)
            case _ => println(-1)
        }

       /* def greetingWithFirstName(name: String) = name match {
            case GivenNames(firstName, second, _*) => s"Greetings $firstName $second"
            case _ => "Welcome, please make sure fill you name!"
        }

        println(greetingWithFirstName("zhu wei feng"))*/

        def greet(fullName: String) = fullName match {
            case GivenNames(firstName, lastName, _*) => s"Hey, $firstName  $lastName"
            case _ => "Welcome, please fill your full name !"
        }

        println(greet("zhu weifeng"))

        val ss = 1 :: 2 :: 3 :: 4 ::Nil
        println(ss.last, ss.head, ss.drop(1).dropRight(1))
    }
}
