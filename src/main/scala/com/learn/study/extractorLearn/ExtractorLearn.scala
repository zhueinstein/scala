package com.learn.study.extractorLearn

/**
  * 创建者： ZhuWeiFeng 
  * 日期： 2018/1/4
  *     提取器
  *
  */

/**
  *  apply unapply 方法
  *     apply方法我们已经非常熟悉了，它帮助我们无需new操作就可以创建对象，而unapply方法则用于析构出对象，
  *     在模式匹配中特别提到，如果一个类要能够应用于模式匹配当中，必须将类声明为case class，因为一旦被定义为case class，
  *     scala会自动帮我们生成相应的方法，这些方法中就包括apply方法及unapply方法。
  *     本节将从提取器（也称析构器）的角度对unapply方法进行介绍。先看下面的这个例子（来源于programmin in scala）
  */
object EMail{
	def apply(user:String, domain: String) = s"$user@$domain"
	def unapply(str: String):Option[(String, String)] = {
		val parts = str split "@"
		if(parts.length == 2) Some((parts(0), parts(1))) else None
	}

}
object ApplyAndUnApply extends App{
	val email = EMail("WeeFon", "ding.com")
	def patternMatching(x: String) = x match {
		case EMail(user, domain) => println(s"user = $user, domain = $domain")
			case _ => println("Others")
	}
	//下面的匹配会导致调用EMail.unapply(email)
	patternMatching(email)
	patternMatching("nono")
}
//从构造与析构的角度来看，apply方法也被称为injection（注入），unapply方法也被称为提取器，
// 这两个方法就像孪生兄弟一样，经常在类或对象中被定义。以前我们在用类进行模式匹配的时候都必须要将类声明为case class，
// 今天我们将不通过case class，而是定义一个普通的类实现自己的apply和unapply方法来实现模式匹配，代码如下：
class Person(val firstName: String, val second: String)
object Person{
	// apply方法
	def apply(firstName:String, secondName: String) = new Person(firstName, secondName)
	// unapply方法
	def unapply(p: Person): Option[(String, String)] = {
		if(p != null) Some(p.firstName, p.second) else None
	}
}
object PersonDemo extends App{
	val p = Person("weeFon", "Red")
	p match {
		case Person(f,s) => println(s"firstName=$f,secondName=$s")
		case _ => "null object"
	}
}

/**
  * 零变量或者单变量的模式匹配
  */

//上一节讲的模式模式匹配绑定的是两个变量，它可以扩展到任意变量维度，这一节中我们对零变量和单个变量绑定的特殊情况进行介绍，我们来看下面的这个例子，该例子来源于 programmin in scala

//Twice用于匹配重复出现的字符串，它绑定的是一个变量
//即返回的类型是Option[String]
object Twice{
	def apply(s:String) = s + s
	def unapply(s:String):Option[String] = {
		val half = s.length/2
		if(s.substring(0, half) == s.substring(half)) Some(s.substring(0, half)) else None
	}
}
object UpperCase{
	def unapply(s:String):Boolean = {
		if(s == s.toUpperCase) true else false
	}
}

//代码中的EMail(Twice(x @ UpperCase())，其执行顺序是先调用EMail的unapply方法，
// 然后再调用Twice中的unapply方法，最后调用UpperCase的unapply方法，如果返回true，则将Twice 中返回的字符串赋值给x
object Demo1 extends App{
	def userTwiceUpper(s:String) = s match {
		//下面的代码相当于执行了下面这条语句
		//UpperCase.unapply(Twice.unapply(EMail.unapply(s)))
		case EMail(Twice(x @ UpperCase()), domain) => s"match $x in domain $domain"
		case  _ => s"no match"
	}

	println(userTwiceUpper(EMail("WeeFonWeeFon", "qq.com")))
}

/**
  *     提取器与序列模式
  *             List 伴生对象具有下列定义形式
  *                     object List {
  *			def apply[T](elems: T*) = elems.toList
  *		        def unapplySeq[T](x: List[T]): Option[Seq[T]] = Some(x)
  *			...
  *			}
  *		从上面的代码中可以看出来，与一般的提取器不同，序列模式采用unapplySeq代替unapply方法，并且返回的类型是option[Seq[T]],
  *	       序列模式中的匹配经常使用占位符_ 或者_*的方式匹配序列中的其他元素，这种方式为序列模式独有
  */
object ExtractorSequence extends App{
	val list = List(List(1,2,3), List(2,3,4))
	list match {
			// _*表示其他的元素
		case List(List(one, two, three), _*) => println(s"one=$one, two=$two, three=$three")
		case _ => println("None matches")
	}

	list match {
			// _ 在第一个元素的位置上表示第一个元素， _*表示 其他更多的元素 x @ List(_*)，采用变量绑定的形式
		case List(_, x@List(_*), _*) => println(s"第二个元素= $x")
		case _ => println("None matches")
	}
}

/**
  *
  *
  *     Scala中的占位符总结
  *
  *
  */
object zhWeiFuDemo extends App{
	//1、存在类型 Existential types
	def foo(l:List[Option[_]]) = {println(l)}
	foo(List(Some(2)))

	//2、高阶类型参数 Higher kinded type parameters
	case class A[K[_], T](a:K[T])
	println(A(List("2", "3", "4")))

	//3、临时变量：Ignored variable
	val _ = 5

	//4、临时参数：Ignored parameters
	List(12,3,4).foreach(_ => println("Hi"))

	//5、通配模式：Wildcard patterns
	Some(5) match {case Some(_) => println("Yes")}
	List(1,2,3) match {
		case List(1,_,_) => println("a list with three element and the first element is 1")
		case List(_*) => println("a list with zero or more elements")
		case _ => println(" None")
	}
	val (a,_) = (1,2)
	println(a)
	for(_ <- 1 to 10){
		print("aaa")
	}

	println()
	// 6、通配导入：Wildcard imports
	//7、隐藏导入：Hiding imports
	// Imports all the members of the object Under extractorLearn  and  renames Foo to Bar
	import com.learn.study.extractorLearn.{Person => P}
	val p = new P("WeFon", "Red")
	println(p.second)

	// Imports all the members except extendsLearn. To exclude a member rename it to _
	// 隐藏Person3类，不能在倒入的作用域里使用
	import com.learn.study.extendsLearn.{Person3 => _}
//	val person3 = new Person3
	//8、连接字母和标点符号
	def bang_!(x: String) = "Boom!!"

	//9、占位符语法 placeHolder syntax
	List(1 ,2,3) map (_ + 2) foreach(println(_))
	val nums = List(1,2,3,33,4,5,6,7,8,9,10)

	nums map (_ +2)
	val nums2 =  nums sortWith (_ >_)
	nums2 foreach (println(_))
	nums filter (_ %2 == 0) foreach (println(_))
	println(nums reduceLeft (_ + _))
	println(nums reduceLeft (_ max _))
	println(3 max 20)
	println(nums exists( _ > 5))
	// takeWhile 从左边开始，相加得到的值满足 参数表达式
	nums takeWhile ( _ < 1)  foreach (println(_))
	// 10、偏函数 Partially applied functions
	def sums(a:Int)(b:Int) = a+b
	val sumsP = sums(3) _
	println(sumsP(3))
	List(1,2,3) foreach println _
	1 to 5 map(10 * _) foreach println _
	//List("foo", "bar", "baz").map(_.toUpperCase())
	List("foo", "bar", "baz").map(n => n.toUpperCase())

	//11、默认初始化值
	var i: Int = _
	i = 3
	println(i)

	//12、作为参数名
	// 访问Map
	var m3 = Map((1,100), (2,200))
	for(e <- m3) println(e._1 + " : " + e._2)
	m3 filter (e => e._2 ==100)  foreach println _
	m3.filterKeys( _ > 1) foreach println _
	// 访问元组
	val tuple3 = Tuple3(1,"2",3.0)
	println(tuple3._2)

	//13、参数序列
		//_*作为一个整体，告诉编译器将某一个参数当作参数序列处理 val s = sum(1 to 5: _*) 就是将1 to 5 当作参数序列
	// Range 转 List
	List(1 to 20: _*) foreach print  _
	// Range 转 Vector
	Vector(1 to 40: _*)
	// 可变参数中
	def capitalizeAll(args: String*) = {
		args map {
			arg => arg.capitalize
		}
	}
	val arr = Array("what", "how", "Else")
	println()
	capitalizeAll(arr : _*).map(println(_))
}
class ExtractorLearn{



}
