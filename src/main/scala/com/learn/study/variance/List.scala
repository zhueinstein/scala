package com.learn.study.variance

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2017/12/15
  */
// 自己定义一个List
class List[+T](head: T, tail: List[T]) extends Animal{
	//下面的方法编译会出错
	//covariant type T occurs in contravariant position in type T of value newHead
	//编译器提示协变类型T出现在逆变的位置
	//即泛型T定义为协变之后，泛型便不能直接应用于成员方法当中
	//def prePend(newHead: T): List[T] = new List[T](newHead, this)
	//将函数也用泛型表示
	//因为是协变的，输入的类型必须是T的超类
	def prePend[U>:T](newHead: U): List[U] = new List[U](newHead, this)
	var count = 0
	def size: Int = {
		val head = this.head
		count += 1
		if(head != null && this.tail != null){
			this.count + this.tail.size
		}else{
			this.count
		}
	}

	def head[U >: T]: U = this.head
	override def toString: String = "" + head
}
class Sequence[-T](head: T, tail: Sequence[T]){
	def prePend[U<:T](newHead: U):Sequence[T] = new Sequence[T](newHead, this)
	def test[U<:T]: U = null.asInstanceOf[U]
}
object NonVariance extends App{
	// 报错
	// Error:(11, 27) type mismatch;
		//found   : com.learn.study.variance.List[String]
	        // required: com.learn.study.variance.List[AnyRef]
		//Note: String <: AnyRef, but class List is invariant in type T.
		//You may wish to define T as +T instead. (SLS 4.5)
	// 最后一句需要使用+T 替换T
	var list: List[String] = new List[String]("永不止步", null)

	val newList = list.prePend("逆变位置").prePend("逆变位置2").prePend("逆变位置3")
	println(newList.size)
	val animals = new List[Dog](Dog("Dog", "Yellow"), null)
	val animalNew = animals.prePend(Cat("Tome", "Gray"))
	animalNew.head.asInstanceOf[Cat].say
	val seq = new Sequence[String]("abc", null)


}
