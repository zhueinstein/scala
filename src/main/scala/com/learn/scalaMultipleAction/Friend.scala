package com.learn.scalaMultipleAction

/**
  * Created by admin on 2017/7/7.
  */
trait Friend {
	var name: String
	def listen = println(s"$name is listening")
}

class Cat(var name:String){

}


object Test extends App{
	def useFriend(friend: Friend) = friend listen

	val snowy = new Cat("Snowy") with Friend
	val friend: Friend = snowy
}