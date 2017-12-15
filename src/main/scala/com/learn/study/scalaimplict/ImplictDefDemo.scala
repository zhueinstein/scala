package com.learn.study.scalaimplict

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2017/12/15
  *
  *     通过隐式转换，程序员可以在编写Scala程序时故意漏掉一些信息，
  *     让编译器去尝试在编译期间自动推导出这些信息来，这种特性可以极大的减少代码量，忽略那些冗长，过于细节的代码。
  *     使用方式：
  *	        1.将方法或变量标记为implicit
  *		2.将方法的参数列表标记为implicit
  *		3.将类标记为implicit
  *	Scala支持两种形式的隐式转换：
	隐式值：用于给方法提供参数
	隐式视图：用于类型间转换或使针对某类型的方法能调用成功

	  隐式转换的时机：

	1.当方法中的参数的类型与目标类型不一致时
	2.当对象调用类中不存在的方法或成员时，编译器会自动将对象进行隐式转换

	隐式解析机制
	即编译器是如何查找到缺失信息的，解析具有以下两种规则：
	1.首先会在当前代码作用域下查找隐式实体（隐式方法  隐式类 隐式对象）
	2.如果第一条规则查找隐式实体失败，会继续在隐式参数的类型的作用域里查找
	类型的作用域是指与该类型相关联的全部伴生模块，一个隐式实体的类型T它的查找范围如下：
	    （1）如果T被定义为T with A with B with C,那么A,B,C都是T的部分，在T的隐式解析过程中，它们的伴生对象都会被搜索
	    （2）如果T是参数化类型，那么类型参数和与类型参数相关联的部分都算作T的部分，比如List[String]的隐式搜索会搜索List的
	伴生对象和String的伴生对象
	    （3） 如果T是一个单例类型p.T，即T是属于某个p对象内，那么这个p对象也会被搜索
	    （4） 如果T是个类型注入S#T，那么S和T都会被搜索

	隐式转换的前提：
	1.不存在二义性（如例1）

	2.隐式操作不能嵌套使用（如 convert1(covert2(x))）+y

	3.代码能够在不使用隐式转换的前提下能编译通过，就不会进行隐式黑铁
  */
class ImplicitDemo {
	//声明person方法。其参数为name，类型String
	// 隐式值
	def person(implicit name: String) = name

}
object MyConversation{
	// 隐式视图
	implicit  def str2Int(str: String ) = str.toInt
}
class SwingType{
	def wantedLearn(sw: String) = println( "学习了" + sw)
}
object swimming{
	implicit def learningType(s: AnimalType ) = new SwingType
}
class AnimalType

/**
  * 还可以将隐式转换函数定义在凶对象中，同样在使用时导入作用域即可
  */
package runningPac{
	object running{
		implicit def run(s: AnimalType) = new SwingType
	}
}
object ImplicitDemo extends App{
	def apply: ImplicitDemo = new ImplicitDemo()
	// ⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇ 测试隐式值 ⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇️
	//      测试隐式值, 直接调用会报错， 找不到隐式值
	//Error:(28, 24) value person is not a member of object com.learn.study.scalaimplict.ImplicitDemo
	//println(ImplicitDemo.person)
	//      先设置一个隐式值, 再次调用， 没问题
	implicit  val name = "Hi"
//	implicit  val name2 = "Again"// 两个相同类型的隐式值，会使使用隐式的地方产生歧义
	println(ImplicitDemo.apply.person)
	//     因为将p变量标记为implicit，所以编译器会在方法省略隐式参数的情况下去搜索作用域内的隐式值作为缺少参数。
	//	但是如果此时你又在REPL中定义一个隐式变量，再次调用方法时就会报错
	//     隐式转换必须满足无歧义规则，在声明隐式参数的类型是最好使用特别的或自定义的数据类型，
	// 不要使用Int,String这些常用类型，避免碰巧匹配
	// ⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️

	// ⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇ 测试隐式值 ⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇⬇️
	//隐式转换为目标类型：把一种类型自动转换到另一种类型
	import MyConversation.str2Int
	println(math.max("1", 2))

	//隐式转换调用类中本不存在的方法
	//编译器在rabbit对象调用时发现对象上并没有wantLearning方法，
	// 此时编译器就会在作用域范围内查找能使其编译通过的隐式视图，
	// 找到learningType方法后，编译器通过隐式转换将对象转换成具有这个方法的对象，之后调用wantLearning方法
	//import com.learn.study.scalaimplict.swimming.learningType
	import com.learn.study.scalaimplict.runningPac.running._
	val rabbit = new AnimalType
	rabbit.wantedLearn("scala")

	//隐式类：
	//在scala2.10后提供了隐式类，可以使用implicit声明类，但是需要注意以下几点：
	//1.其所带的构造参数有且只能有一个
	//2.隐式类必须被定义在类，伴生对象和包对象里
	//3.隐式类不能是case class（case class在定义会自动生成伴生对象与2矛盾）
	//4.作用域内不能有与之相同名称的标示符
	import com.learn.study.scalaimplict.StringUtils._
	println("wf".improvement)
	//编译器在mobin对象调用increment时发现对象上并没有increment方法，此时编译器就会在作用域范围内搜索隐式实体，
	// 发现有符合的隐式类可以用来转换成带有increment方法的StringImprovement类，最终调用increment方法。
	// ⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️


}
// 隐式类
object StringUtils{
	implicit class StringImprovement(s: String){
		def improvement = s.map( c => (c + 1).toChar)
	}
}