package com.learn.scalaMultipleAction

/**
  * Created by admin on 2017/7/7.
  */
class Pet(val name: String) {
	override def toString: String = name
}

class Dog(override val name: String) extends Pet(name){
	override def toString: String = name
}

object test extends App{
	def workWithPets[T <: Pet](pets: Array[T])={}

	val dogs = Array(new Dog("a"), new Dog("b"))

	workWithPets(dogs)

	def copy[S,D >:S](f: Array[S], t:Array[D]) = {}
	val pets = new Array[Pet](10)
	copy(dogs, pets)

	def inject(array:Array[Int], initial: Int, f:((Int, Int) => Int)):Int={
		var carryOver = initial
		array.foreach{elem => carryOver = f(carryOver, elem)}
		carryOver
	}

	println(inject(Array(1, 3, 4, 5, 6), 0, (a: Int, b: Int) => a + b))

	val array = Array(1,2,3,4,56,2)
	def sum = (0 /: array) {(sum, elem) => sum + elem}
}
