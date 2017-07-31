package com.learn.akka.actors

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}

/**
  * Created by admin on 2017/7/12.
  */
class MyActor extends Actor with ActorLogging{
	import MyActor._
	override def receive = {
		case Greeting(greeter) => log.info(s"I was greeted by $greeter.")
		case GoodBye => log.info("Someone said goodbye to me.")
	}
	val child = context.actorOf(Props[MyActor], name ="myActor1")
}
object MyActor{
	case class Greeting(from: String)
	case object GoodBye

	def apply: MyActor = new MyActor()
	def main(args: Array[String]): Unit = {
		val system = ActorSystem("myActor")
		val myActor = system.actorOf(Props[MyActor], "myActor")
		val firstActor = system.actorOf(Props[FirstActor], "firstActor")
		myActor ! Greeting("LiBai")
		firstActor ! Greeting("lili")

	}
}

