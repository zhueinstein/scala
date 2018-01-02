package com.learn.study.caseClass

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2018/1/2
  *     模式匹配
  */

/**
  * 模式匹配的类型
  *  1、常量模式
  */
object ConstantPattern  extends App{
	def patternShow(x: Any) = x match {
		case 5 => 5
		case true => "true"
		case "test" => "test"
		case null => "null"
		case Nil => "Empty List"
		case _ => "Other Constant"
	}

	println(patternShow(5))
}

/**
  *  2、变量模式
  */
object VariablePattern extends App{
	def patternShow(x: Any) = x match {
			case 5 => 5
			case any => any
	}

	println(patternShow("23434"))
}

/**
  *  3、构造器模式
  *  构造器模式必须将类定义为case class
  */
case class Persons(name: String, age: Int)
object ConstructorPattern extends App{
	val p: Persons = Persons("WeFon", 29)
	def patternShow(x: Persons) = x match {
		case Persons(name, age) => s"name is $name and age is $age"
		case _ => "Other"
	}

	println(patternShow(p))
}

/**
  * 4 序列（Sequence)模式
	序列模式指的是像Array、List这样的序列集合进行模式匹配
  */
object SequencePattern extends App{
	val list = List("Scala", "Spark", "Java")
	def patternShow(x: Seq[String]) = x match {
		case List(_, second, _) => second
		case _ => "Other List"
	}

	println(patternShow(list))
}

/**
  *  5、元组模式
  *     匹配元组
  */
object TuplePattern extends App{
	def patternShow(x: Any) = x match {
		case Tuple3(_, second, _) => second
		case Tuple2(first, _) => first
		case _ => "Other"
	}
	val tuple3 = Tuple3("Spark", "Scala", "Java")
	println(patternShow(tuple3))
}
/**
  * 6、类型模式
  *     匹配参数的类型
  */
object TypePattern extends  App{
	def patternShow(x: Any) = x match {
		case x: String => "String"
		case s: Double => "Double"
		case s: Int => "Int"
		case s: BigDecimal => "BigDecimal"
	}

	println(patternShow(5))
}
/**
  * 7、变量绑定模式
  *
  */
object VariableBindPattern extends App{
	val t = List(List(1,2,3),List(4,5,6))
	def patternShow(x: Any) = x match {
		// 变量绑定，使用变量名（e）与@符号， 如果匹配成功，返回整体匹配的结果
		case List(_, e@List(_,_,_)) => e
		case _ => "Other"
	}

	println(patternShow(t))
}

/**
  * for控制结构中的模式匹配
  */
object LoopPattern extends App{
	val map = Map("beijing" -> 10000.0, "shanghai" -> 9000.00, "zhengzhou" -> 5000.0)
	for((key, value) <- map){
		println(s"城市 $key 平均工资$value")
	}
}
/**
  * 正则表达式模式匹配
 */
object RegexPattern extends App{
	val ipRegex = "(\\d{0,3})\\.(\\d{0,3})\\.(\\d{0,3})\\.(\\d{0,3})".r
	for(ipRegex(one, two, three, four) <- ipRegex findAllIn "10.1.10.127"){
		println(one)
		println(two)
		println(three)
		println(four)
	}
}

/**
  *
  * option 类型匹配
  *     Option类型有两个子类： Some和None（单例对象）
  *             Some 是case class 类型
  *             None 是 case object类型 ，不会生成apply和unapply方法，因为None不需要新建对象和从对象中提取内容
  */

object OptionPattern extends App{
	val map = Map("Scala" -> 2007, "Java" -> 1995)
	def patternShow(x: String) = map.get(x) match {
		case Some(x) => println(x);x
		case None => "None"
	}

	println(patternShow("Scala"))
}