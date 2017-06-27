package com.learn.beginnerForScala.curry

/**
  * Created by admin on 2017/6/27.
  */
object MockEmailRepository extends EmailRepository{
    override def getMails(user: User, unread: Boolean): Seq[Email] = Nil
}
