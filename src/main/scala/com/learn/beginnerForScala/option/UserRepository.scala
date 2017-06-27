package com.learn.beginnerForScala.option

/**
  * Created by admin on 2017/6/23.
  */
object UserRepository {
    private val users = Map(1 -> User(1, "John", "Doe", 32, Some("male")),
        2 -> User(2, "Johanna", "Doe", 30, None))
    def findById(id: Int): Option[User] = users.get(id)
    def findAll = users.values
}
