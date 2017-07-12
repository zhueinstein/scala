package com.learn.akka.actors

import akka.actor.{Actor, ActorRef, ActorSystem, PoisonPill, Props}

import scala.language.postfixOps
import scala.concurrent.duration._
case object Ping
case object Pong
/**
  * Created by admin on 2017/7/12.
  */
class Pinger extends Actor{
	var countDown = 100
	def receive: Receive = {
		case Pong =>
			println(s"${self.path} received pong, count down $countDown")
			if(countDown > 0){
				countDown -= 1
				sender() ! Ping
			}else{
				sender() ! PoisonPill
				self ! PoisonPill
			}
	}
}

class Ponger(pinger: ActorRef) extends Actor{
	def receive: Receive = {
		case Ping =>
			println(s"${self.path} received")
			pinger ! Pong
	}
}

object Test extends App{
	val system = ActorSystem("pingpong")
	val pinger = system.actorOf(Props[Pinger], "pinger")

	val ponger = system.actorOf(Props(classOf[Ponger], pinger), "ponger")
	import system.dispatcher
	system.scheduler.scheduleOnce(500 millis) {
		ponger ! Ping
	}
}

