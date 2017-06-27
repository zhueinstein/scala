package com.learn.beginnerForScala.extractor

/**
  * Created by admin on 2017/6/22.
  */
object PremiumCandidate {
    def unapply(user: FreeUser): Boolean = user.upgradeProbability > 0.75
}
