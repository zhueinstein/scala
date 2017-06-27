package com.learn.beginnerForScala.curry

/**
  * Created by admin on 2017/6/27.
  */
trait EmailRepository {
    def getMails(user: User, unread: Boolean):Seq[Email]
}
