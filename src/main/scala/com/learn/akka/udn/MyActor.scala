package com.learn.akka.udn

import akka.actor.{Actor, ActorSystem, Props}
import akka.event.Logging

/**
  * Created by zcx on 2017/7/31.
  */
class MyActor extends Actor{
	val log = Logging(context.system, this)
	def receive = {
		case "test" =>log.info("receive test")
		case  _ =>log.error("receive  unknown message")
	}
}

object MyActor extends App{
	val system = ActorSystem(name = "system")
	val myActor = system.actorOf(Props[MyActor], "myActor");
	myActor ! "test"
}
