package com.learn.beginnerForScala.option

/**
  * Created by admin on 2017/6/23.
  */
case class User(id: Int,
                firstName: String,
                lastName: String,
                age: Int,
                gender: Option[String])
object TestDemo extends App{
    val user1 = User(2, "zhu", "wf", 10, None)
    val gender = user1.gender.getOrElse("没有定义")
    println(s"$gender")

    user1.gender match {
        case Some(gender)  => println(s"$gender")
        case None => println("Gender: not specified")
    }

    UserRepository.findById(21).foreach(user => println(user.gender))
    val age = UserRepository.findById(2).map(_.age)
    println(s"$age")

    val gender1 = UserRepository.findById(1).map(_.gender)
    println(s"$gender1")

    val gender2 = UserRepository.findById(1).flatMap(_.gender)
    val gender3 = UserRepository.findById(3).flatMap(_.gender)

    println(s"$gender2, $gender3")

    val names = List(List("a", "b", "c"), List(), List("d", "e"))
    println(names.map(_.map(_.toUpperCase)))

    println(names.flatMap(_.map(_.toUpperCase())))

    val gends = for{
        User(_, _, _, _, Some(gender)) <- UserRepository.findAll
    } yield gender
    println(s"$gends")
}
