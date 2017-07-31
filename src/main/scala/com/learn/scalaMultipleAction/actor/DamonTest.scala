package com.learn.scalaMultipleAction.actor

import akka.actor.Props
import akka.actor.UntypedActor
/**
  * Created by admin on 2017/7/11.
  */
object DamonTest extends App{
	def sumOfFactors(number: Int)={
		(0 /: (1 to number)){(sum, i) => if(number % i == 0) sum + i else sum}
	}

	def isPerfact(candidate: Int) = 2 * candidate == sumOfFactors(candidate)

	println("6 是完全数吗？" + isPerfact(6))
	println("33550336 是完全数吗？" + isPerfact(33550336))
	println("33550337 是完全数吗？" + isPerfact(33550337))
	println(sumOfFactors(33550336))

	/*def sumOfFactorsInRange(lower: Int, upper: Int, number: Int)={
		(0 /: (lower to upper)){(sum, i) => if(number % )}
	}

	def isPerfactConcurrent(candidate: Int)={
		val RANGE = 1000000
		val numberOfPartitions = (candidate.toDouble / RANGE).ceil.toInt
		val  caller = self
	}*/
}
