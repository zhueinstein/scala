package com.learn.akka.actors

import akka.actor.{Actor, Props}

/**
  * Created by admin on 2017/7/12.
  */
object DemoActor{
	def props(magicNumber: Int): Props = Props(new DemoActor(magicNumber))
}
class DemoActor(magicNumber: Int)  extends Actor{

	def receive = {
		case x: Int => sender() ! (x + magicNumber)
	}

}

class SomeOtherActor extends Actor{
	def receive:Receive = ???
	context.actorOf(DemoActor.props(42), "demo")
}
