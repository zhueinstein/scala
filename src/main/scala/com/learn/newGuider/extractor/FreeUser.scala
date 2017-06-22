package com.learn.newGuider.extractor

/**
  * Created by admin on 2017/6/22.
  */
class FreeUser(val name: String, val score: Int, val upgradeProbability: Double) extends User
object FreeUser{
    def unapply(user: FreeUser):Option[(String, Int, Double)] = Some(user.name, user.score, user.upgradeProbability)
}
