package com.learn.beginnerForScala.extractor

/**
  * Created by admin on 2017/6/22.
  */
object GivenNames {
    /**
      * 多个值的提取器，返回的是一个Seq
      */
   /* def unapplySeq(name: String): Option[Seq[String]] ={
        val names = name.trim.split(" ")
        if(names.forall(_.isEmpty)) None
        else Some(names)
    }*/

    def unapplySeq(name: String):Option[(String, String, Seq[String])] ={
        val names = name.trim.split(" ")
       if(names.length < 2) None
       else Some(names.last, names.head, names.drop(1).dropRight(1))
   }
}
