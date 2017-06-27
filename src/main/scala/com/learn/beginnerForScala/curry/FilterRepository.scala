package com.learn.beginnerForScala.curry

import com.learn.beginnerForScala.curry.PartFucDemo.EmailFilter

/**
  * Created by admin on 2017/6/27.
  */
trait FilterRepository {
    def getEmailFilter(user: User):EmailFilter
}
