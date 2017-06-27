package com.learn.beginnerForScala.curry
import com.learn.beginnerForScala.curry.PartFucDemo.EmailFilter

/**
  * Created by admin on 2017/6/27.
  */
object MockFilterRepository extends FilterRepository{
    override def getEmailFilter(user: User): EmailFilter = _ =>true
}
