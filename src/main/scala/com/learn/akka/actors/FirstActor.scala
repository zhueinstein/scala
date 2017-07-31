package com.learn.akka.actors

import akka.actor.{Actor, Props}

/**
  * Created by admin on 2017/7/12.
  */
class FirstActor extends Actor{
	val child = context.actorOf(Props[MyActor], name = "myActor1")
	def receive = {
		case x => child ! x
	}
}
