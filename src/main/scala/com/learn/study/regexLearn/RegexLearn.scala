package com.learn.study.regexLearn

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2017/12/29
  *     正则表达式
         在众多的编程语言当中，包括JAVA、Perl、PHP、Python、JavaScript和JScript，都无一例外内生地支持正则表达式处理。Scala语言同样支持正则表达式，当然，scala可以直接通过Java操作正则表达式的方式使用正则表达式，但scala实现了自己的方式，它更为灵活。值得一提的是正则表达式并不只属于某一门程序语言，它已经超出了某种语言或某个系统的局限，成为被人们广为使用的工具。
	在程序开发中，经常会碰到需要匹配、查找、替换、判断字符串，如果用纯编码方式解决的话，难度较大，而且很浪费时间，通过正则表达式可以解决这些问题。下面给出正则表达式中常用符号的含义：
	1 句点符号.，它是一种通配符，用于匹配一个字符，例如Spa.k，可以匹配Spark、Spaak等任意字母组成的字符串，还可以匹配Spa#k，Spa k等特殊字符组成的字符串
	2 []，限定匹配，例如Spa[ark]k只会匹配Spark,Spaak,Spakk这三个字符串，对于其它的不会匹配
	3 |， 或匹配，例如Spa(a|r|rr|k)k，则可以匹配Spark,Spaak,Spakk及Sparrk
	4 $，匹配行结束符，例如Spark$ 匹配的是以Spark$ 为结尾行，例如I love Spark，但它不匹配Spark will be very poupular in the future
	5 ^，匹配行开始符，例如^Spark匹配的是以Spark开始的行，如Spark will be very poupular in the future，不匹配I love Spark
	6 *，匹配0至多个字符，例如Spar*，可以匹配任何Spar开始的字符串，如Spar,Spark,Sparkkkkk
	7 /，转义符，例如Spark/$ 匹配的是包含Spark$的字符串
	8 ( )，分组符，它会将()中匹配的内容保存起来，可以对其进行访问，例如Spa(a|r|rr|k)k可以对()中匹配的内容保存为一个临时变量，在程序中可以直接对其进行访问
	9 +，匹配一次或多次例如Spar+，可以匹配任何Spar开始的字符串，如Spark,Sparkkkkk
	10 ?，匹配0次或一次，例如Spark(s)? 可以匹配Spark和Sparks
	11 {n}，匹配n次，例如Spark{2}，可以匹配I love Sparkk中的Sparkk
	12 {n,}，至少匹配n次，例如Spark{2，}可以匹配I love Sparksss Sparkss中的Sparksss和Sparkss
	13 {n,m}，至少匹配n次，最多匹配m次，Sparks{2,4}可以匹配I love Sparks Sparkssss中的Sparkssss

	限定匹配[]的用法非常灵活，有必要对其进行进一步的说明：
	[a-z]     条件限制在小写a to z范围中一个字符
	[A-Z]     条件限制在大写A to Z范围中一个字符
	[a-zA-Z] 条件限制在小写a to z或大写A to Z范围中一个字符
	[0-9]     条件限制在小写0 to 9范围中一个字符
	[0-9a-z] 条件限制在小写0 to 9或a to z范围中一个字符
	[0-9[a-z]] 条件限制在小写0 to 9或a to z范围中一个字符(交集)
	^符号在限定匹配[]中有另外的含义，即取反操作
	[^a-z]     条件限制在非小写a to z范围中一个字符
	[^A-Z]     条件限制在非大写A to Z范围中一个字符
	[^a-zA-Z] 条件限制在非小写a to z或大写A to Z范围中一个字符
	[^0-9]     条件限制在非小写0 to 9范围中一个字符
	[^0-9a-z] 条件限制在非小写0 to 9或a to z范围中一个字符
	其它特殊字符：
	\ 反斜杠
	\t 间隔 (‘/u0009’)
	\n 换行 (‘/u000A’)
	\r 回车 (‘/u000D’)
	\d 数字 等价于[0-9]
	\D 非数字 等价于[^0-9]
	\s 空白符号 [/t/n/x0B/f/r]
	\S 非空白符号 [^/t/n/x0B/f/r]
	\w 单独字符 [a-zA-Z_0-9]
	\W 非单独字符 [^a-zA-Z_0-9]
	\f 换页符
	\e Escape
	\b 一个单词的边界
	\B 一个非单词的边界
	\G 前一个匹配的结束
  */
object RegexLearn extends App{
	// 匹配邮箱
	val mail = """^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$""".r
	for(matching <- mail findAllIn("675748324@qq.com")){
		println(matching)
	}
	// 匹配网址
	val urlR = """^[a-zA-Z]+://(\w+[-\w]*)(\.(\w+[-\w]*))*:*[0-9]*(\?\s)*""".r
	for (matching <- urlR findAllIn "http://www.baidu.com"){
		println(matching)
	}
	//   匹配手机号码
	val phone = """^1[345678]{1}[\d]{9}""".r
	for (matching <- phone findAllIn "15210976357"){
		println(matching)
	}
	// 匹配ip
	val ip = """\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}""".r
	for (matching <- ip findAllIn "10.1.10.127"){
		println(matching)
	}

	/**
	  * 在scala中，有一个非常非常强大的功能，那就是提取器（Extractor)。
	  * 使用提取器必须要匹配提取的数量, 即是使用分组符()分组的数量
	  */
	val ipRegex = """(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})""".r
	for(ipRegex(one, two, three, four) <- ipRegex findAllIn "10.1.10.127"){
		println("IP子段1:"+one)
		println("IP子段2:"+two)
		println("IP子段3:"+three)
		println("IP子段4:"+four)
	}
	// 提取邮箱的名称
	 // 对于自己想要提取的文字对应正则分组的位置，不需要提取的使用_*来表示
	val mailRegex = """^([\w-]+(\.[\w-]+)*)@[\w-]+(\.[\w-]+)+$""".r
	for(mailRegex(name,_*) <- mail findAllIn("675748324@qq.com")){
		println(name)
	}

}
