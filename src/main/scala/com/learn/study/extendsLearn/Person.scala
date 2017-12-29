package com.learn.study.extendsLearn

/**
  * 创建者： ZhuWeiFeng 
  * 日期：2017/12/28
  * 继承 和 多态
  *     1、继承
  *     2、构造函数执行顺序 先父类再子类
  *     3、方法重写
  *             当子类继承父类的时候，从父类继承过来的方法不能够满足子类的需要，子类需要有自己的实现，这时需要对父类方法的重写，
  *             方法的重写是多态和动态绑定的关键
  *             scala与java一样，使用override标识重写父类算法
  *             如果父类是一个抽象类，子类在实现父类方法的时候可以不加override关键字，因为子类必须实现父类的抽象方法和对成员字段的初始化
  *       4、匿名类
  *             当某个类再程序中只使用一次，可以将其定义为匿名类 eg. Person2
  *        5、多态和动态绑定
  *             多态也叫动态绑定、迟绑定，指的是在执行期间（而非编译时间）才能确定所引对像的实际类型，根据实际类型调用x相应的方法。即 子类的引用可以赋给父类。
  *             eg. Animal
  *         6、组合与继承的使用 eg. Person3
  *              继承可以重用父类的代码，从而简化代码，继承是is-a的关系。
  *                     优点：子类可以重写父类的方法方便的对父类方法进行扩展
  *                     缺点：1、父类的内部细节对子类都是可见的
  *                               2、子类从父类继承的方法从编辑时就已经确定下来的，所以无法在运行期改变从父类继承的行为
  *                               3、如果父类的方法做修改的化，子类也必须作出修改，继承是一种高度耦合的行为，违背了面向对象的原则
  *              组合是has-a的关系，也就是设计类的时候要把组合的类的对象加入到自己的类中变成自己的成员变量
  *                       优点：1、当前对象只能通过所包含的组合类的对象去调用其方法，所以包含对象细节当前对象并不可见
  *                                 2、当前对象与包含对象是一种低耦合的关系， 如果修改包含对象的代码不需要修改当前对象类的代码
  *                                 3、当前对象可以在运行时动态的绑定包含的对象。可以通过set方法对包含对象赋值
  *                       缺点：1、容易产生过多的对象
  *                                 2、为了组合多个对象，必须仔细对接口进行定义
  *             组合毕继承更具有灵活性与稳定性，推荐优先使用组合，只有满足以下条件时才考虑使用继承
  *                     1、子类是一个特殊的类型，而不是父类的某一个角色
  *                     2、子类的实例不需要变成另一个类的对象
  *                     3、子类扩展，而不是覆盖或使父类的功能失效
  *
  *
  *
  */
// Person类
class Person(name: String, age: Int) {
	println("Peron ******")

	def walk() = println("Walk Like A Normal Person ")
}
class Student(name: String, age: Int, studentNo: Int) extends Person(name: String, age: Int){
	println("Student ****")

	override
	def walk(): Unit = {
		println("Walk Like A Student ")
	}
}

object Demo extends App{
	val student = new Student("Lily", 22, 2222)
	student.walk()
}

abstract class Person2(name: String, age: Int){
	def say():Unit
}

object demo2{
	def main(args: Array[String]): Unit = {
		val person2 = new Person2("Lucy", 22) {
			override
			def say(): Unit = {println("Go Away!!")}
		}
		person2.say()
	}
}

// 抽象的Animal类
abstract class Animal(var name: String, age: Int){
	def walk(): Unit

	def talkTo(animal: Animal): Unit
}

class Dog(name: String, age: Int) extends Animal(name, age){
	override def walk(): Unit = {println("Walk Like a Dog")}

	override def talkTo(dog: Animal): Unit = {
		println("talkTo() method in Dog")
		println(this.name + " talk to " + dog.name)
	}
}

class Cat(name: String, age: Int) extends Animal(name, age){
	override def walk(): Unit = println("Walk Like a Cat")

	override def talkTo(cat: Animal): Unit = {
		println("talkTo() method in Cat")
		println(this.name + " talk to " + cat.name)
	}
}

object AnimalDemo extends App{
	//下面的两行代码演示了多态的使用
	//Animal类的引用可以指向Animal类的任何子类
	val animal1:Animal = new Dog("Dong", 3)
	val animal2:Animal = new Cat("Cate", 2)

	//下面的两行代码演示了动态绑定
	//talkTo方法参数类型为Person类型
	//animal1.talkTo(animal2)传入的实际类型是Cat
	//animal2.talkTo(animal1)传入的实际类型是Dog
	//程序会根据实际类型调用对应的不同子类中的talkTo()方法
	animal1.talkTo(animal2)
	animal2.talkTo(animal1)
}

class Head(var eyeColor: String)
class Body(var high: Double)
class Hand(var length: Double)
// 组合
abstract class Person3(var name: String, var age: Int){
	// 各类的实例作为该类对象的一部分，通过各类的实例方法实现代码重用
	var head: Head = null
	var body: Body = null
	var hand: Hand = null
}

class Worker(name: String, age: Int) extends Person3(name, age){
	head = new Head("blue")
	body = new Body(190)
	hand = new Hand(233)

	def description(): Unit ={
		println("eyeColor is " + this.head.eyeColor)
		println("body high is " + this.body.high)
		println("hand length is " + this.hand.length)
	}
}

object Worker{
	def main(args: Array[String]): Unit = {
		val worker = new Worker("Carver", 28)
		worker.description()
		worker.hand.length = 33333
		worker.description()
	}
}