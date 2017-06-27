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


        val gameResults:Seq[(String, Int)] = ("wifu", 1000)::("sdas", 2000)::("hello", 3000)::Nil;

        def names = for {
            result <- gameResults
            (name, score) = result
            if(score > 2000)
        } yield name

        println(s"$names")

        /**
          * 去除空的集合
          */
        val list = List(0,1,2,3)::List.empty::List(4,3)::Nil
       val filter =  for {
            list@ head :: _ <- list
        } yield list

        println(s"$filter")

        /**
          * 小写转大写
          */

        val songList = List("we are champion", "the moon")
        println(songList.map(_.toUpperCase))


        val wordFrequencies = ("habitual", 6) :: ("and", 56) :: ("consuetudinary", 2) ::
            ("additionally", 27) :: ("homely", 5) :: ("society", 13) :: Nil
        def wordsWithoutLines(wordFrequencies: Seq[(String, Int)]): Seq[String] =
            wordFrequencies.filter(wf => wf._2 > 3 && wf._2 < 25).map(_._1)

        println(wordsWithoutLines(wordFrequencies))

        def wordsWithoutLines2(wordFrequencies: Seq[(String, Int)]): Seq[String] =
            wordFrequencies.filter{ case (_, t) => t > 3 && t < 25 } map {case (w, _) => w}

        /**
          * 偏函数写法
          */
        def wordsWithoutLines3(wordFrequencies: Seq[(String, Int)]): Seq[String] =
            wordFrequencies.collect{case (w, t)  if t > 3 && t < 25 => w}
    }
}
