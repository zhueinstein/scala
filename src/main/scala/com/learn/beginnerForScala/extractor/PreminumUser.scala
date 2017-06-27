package com.learn.beginnerForScala.extractor

/**
  * Created by admin on 2017/6/22.
  */
class PreminumUser(val name: String, val score: Int) extends User

object PreminumUser{
    def unapply(user:PreminumUser):Option[(String, Int)] = Some(user.name, user.score)
}