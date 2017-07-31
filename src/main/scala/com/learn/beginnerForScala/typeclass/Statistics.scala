package com.learn.beginnerForScala.typeclass



/**
  * Created by zcx on 2017/6/27.
  */
object Statistics {
	import Math.NumberLike//
	def mean[T](xs: Vector[T])(implicit ev: NumberLike[T]): T =
		ev.divide(xs.reduce(ev.plus(_, _)), xs.size)

	def median[T: NumberLike](xs:Vector[T]):T = xs(xs.size/2)
	def quartiles[T:NumberLike](xs:Vector[T]):(T, T, T) =
		(xs(xs.size/4), median(xs), xs(xs.size *3 / 4))

	def iqr[T:NumberLike](xs:Vector[T]):T = quartiles(xs) match {
		case (low, _ , high) => implicitly[NumberLike[T]].minus(high,low)
	}
	def main(args: Array[String]): Unit = {
		val numbers = Vector[Double](1,2,3,0)
		println(mean(numbers))

		/*val strs = Vector[String]("a","d")
		println(mean(strs))*/

//		val durations = Vector[Duration](standardSeconds(2000), standardSeconds(213131))
//		println(mean(durations))
	}
}
