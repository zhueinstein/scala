package com.learn.scalaMultipleAction

import DateHelper._
/**
  * Created by admin on 2017/7/10.
  */
object DamonTest extends App{
	val applicationCheck = new Check with CreditCheck with CriminalCheck
	println(applicationCheck.check())

	val writer1 = new StringWriterDelagate with UpperCaseWriter with ProfanityWriter
	val writer2 = new StringWriterDelagate with ProfanityWriter with UpperCaseWriter
	writer1 writeMessage "Here is no sin but stupidTy"
	writer2 writeMessage "Here is no sin but stupidTy"
	println(writer1)
	println(writer2)



	val past = 2 days ago
	val appointment = 5 days from_now
	val ss = 4 days "now"
	val sum = 5 add 4
//	val sss = "2" days ago
//	println(s"$sss" )
//	val Lily = TestEntity("lily", 18)
//	val age = Lily days years_ago
//	println(s"$age")

	var feeds = scala.collection.mutable.Map(("Deaver" ->"We"),("Bera" -> "He was"))

	val filtered = feeds filter {element =>
		val (key, value) = element
		(key startsWith  "D") && (value contains  "W")
	}

	println(filtered)

	var newfeeds = feeds.updated("lili","das")
	println(newfeeds)

	feeds("ok") = "good"
	println(feeds)

	val feedsList = List[String]("book", "coffee", "food", "pen", "kids")

	println(feedsList head)
	println(feedsList(1))

	val preFiexList = "Oops" :: feedsList
	println("--" + feedsList.::("Oops"))
	println(preFiexList)

	val listA = List("BookA", "BookB")

	val newLL = listA ::: feedsList
	println(newLL)

	println(feedsList.forall(_ contains "book"))
	println(feedsList.map(_.length).mkString(","))

	println(feedsList.foldLeft(0){(total, feed) => total + feed.length })

	(0 /: feedsList){(total, feed) => total + feed.length}
	val total3 = (0 /: feedsList){_ + _.length}
	println(total3)

	val sample = new Sample
	+sample
	-sample
	!sample
	~sample

	println(for (i <- 1 to 10) yield i * 2)

	println(for (i <- 1 to 10; if (i % 2 == 0)) yield i * 2)

	println(for {
		i <- 1 to 10
		if (i % 2 == 0)
	} yield i * 3)

	def process(input: Any): Unit ={
		input match {
			case (a:Int,b:Int) => println("Processing (Int,Int)……")
			case (a:Double,b:Double) => println("Processing (Double,Double)……")
			case msg:Int if(msg > 100) => println("Processing msg > 100")
			case msg:Int => println("Processing Int……")
			case msg:String =>println("Processsing String")
			case _ => println("Can't handle %s", input)
		}
	}

	process((10.0, 100.0))

	val max = 100
	val MIN = 1

	def damon(input:Int): Unit ={
		input match {
			case this.max => println(max)
			case MIN => println(MIN)
				case _ => println("Default")
		}
	}
	damon(90)

	val pattern = "(S|s)cala".r
	val str = "Scala is cool and scalable language"
	println(pattern findFirstIn "scala")
	println("cool".r replaceFirstIn(str ,"awesome"))
}
