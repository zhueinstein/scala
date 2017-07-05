package com.learn.beginnerForScala.typeclass

import org.joda.time.Duration


/**
  * Created by zcx on 2017/6/27.
  */
object JodaImplicits {

	import Math.NumberLike

	implicit object NumberLikeDuration extends NumberLike[Duration]{
		override def plus(x: Duration, y: Duration): Duration = x.plus(y)

		override def minus(x: Duration, y: Duration): Duration = x.minus(y)

		override def divide(x: Duration, y: Int): Duration = Duration.millis(x.getMillis/y)
	}

}
