package com.learn.study.variance

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2017/12/15
  *     类型参数- 协变 与 逆变
  */
// 自己定义一个List
/**
  *     协变
  *     协变定义形式如：trait List[+T] {} 。当类型S是类型A的子类型时，则List[S]也可以认为是List[A}的子类型，即List[S]可以泛化为List[A]。
  *             也就是被参数化类型的泛化方向与参数类型的方向是一致的，所以称为协变（covariance）。
  */
class List[+T](head: T, tail: List[T]) extends Animal{
	//下面的方法编译会出错
	//covariant type T occurs in contravariant position in type T of value newHead
	//编译器提示协变类型T出现在逆变的位置
	//即泛型T定义为协变之后，泛型便不能直接应用于成员方法当中
	//def prePend(newHead: T): List[T] = new List[T](newHead, this)
	//将函数也用泛型表示
	//因为是协变的，输入的类型必须是T的超类
	// def prePend[U>:T](newHead: U): List[U]  参数出现的位置 是 逆变点
		// 根据协变定义 如果逆变点传入的参数类型不是T的父类的话，那么 新生成的new List[T] 也不会是List[T]的父类
		// 如果 传入U>:T 新生成的List[U]也会是List[T]的父类，符合协变定义，也符合里氏替换原则， List[T]出现的位置，List[U]也可以出现
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

/**
  * 逆变
  *     逆变定义形式如：trait List[-T] {}
  *	当类型S是类型A的子类型，则Queue[A]反过来可以认为是Queue[S}的子类型。也就是被参数化类型的泛化方向与参数类型的方向是相反的，所以称为逆变（contravariance）。
  *
  */
class Sequence[-T](head: T, tail: Sequence[T]){
	// def prePend[U<:T](newHead: U):Sequence[T] 参数出现的位置是 协变点
		// 根据逆变的定义， U是T的子类，则Sequence[U] 则会是new Sequence[T]的父类, 根据里氏替换原则，Sequence[U] 可以出现在Sequence[T]的位置
	def prePend[U<:T](newHead: U):Sequence[U] = new Sequence[U](newHead, this)
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

/**
  *     类型通配符
  *             类型通配符是指在使用时不具体指定它属于某个类，而是只知道其大致的类型范围，通过”_ <:” 达到类型通配的目的，如下面的代码
  */
class Person(name: String, age: Int)

case class Student(name: String, age:Int, sNo: Int) extends Person(name, age)
case class Teacher(name: String, age: Int, tNo: Int) extends Person(name, age)
class Pair[T](val a: T,val b:T) {

	override def toString = s"Pair($a, $b)"
}
object TongPeiDemo extends App{
	//Pair的类型参数限定为[_<:Person]，即输入的类为Person及其子类
	//类型通配符和一般的泛型定义不一样，泛型在类定义时使用，而类型能配符号在使用类时使用
	def test(p: Pair[_<:Person]) = {
		println(p.a + " teaches " + p.b)
	}
	test(new Pair[Person](new Teacher("WeFon", 29, 1), new Student("Lily", 18, 1))) 
}
