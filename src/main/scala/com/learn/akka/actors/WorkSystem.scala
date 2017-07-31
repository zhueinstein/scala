package com.learn.akka.actors

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by zcx on 2017/7/31.
  */
object WorkSystem extends App{

	case class Print(val x: Int)

	class WorkActor1 extends Actor{
		val seq = Seq(1,2,3,4,5)
		val work2 = context.actorSelection("/user/work2")
		def receive: Receive = {
			case Print(x) => x match {
				case i if i < 5 => println(s"${self.path} ${seq(i)}")
					work2 ! Print(i)
				case _ => context.system.terminate()
			}


		}
	}

	class WorkActor2 extends Actor{
		val seq = Seq(11,12,13,14,15)
		def receive: Actor.Receive = {
			case Print(x) if x < 5=> println(s"${self.path}: ${seq(x)}")
				sender() ! Print(x+1)
		}
	}

	val system = ActorSystem("work")
	val work1 = system.actorOf(Props[WorkActor1], "work1")
	val work2 = system.actorOf(Props[WorkActor2], "work2")
	work1 ! Print(0)
}
