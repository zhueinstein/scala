package com.learn.tryCatch

import java.io.InputStream
import java.net.URL

import scala.util.Try

/**
  * Created by zcx on 2017/6/24.
  */
class CrapperDemo {
    def paraseUrl(url:String):Try[URL] = Try(new URL(url))

  def inputStreamForUrl(url:String):Try[Try[Try[InputStream]]] = paraseUrl(url).map{ u =>
    Try(u.openConnection()).map(conn => Try(conn.getInputStream))}

  def inputStreamForUrlFlatMap(url: String):Try[InputStream] = paraseUrl(url).flatMap{
    u => Try(u.openConnection()).flatMap(conn => Try(conn.getInputStream))
  }

}

object CrapperDemo{
  def apply: CrapperDemo = new CrapperDemo()
  def main(args: Array[String]): Unit = {
    println(CrapperDemo.apply.paraseUrl("http://baidu.com"))
   //val string=  CrapperDemo.apply.paraseUrl(Console.readLine()) getOrElse new URL("http://abc.com")
    //println(s"$string")


    println(CrapperDemo.apply.inputStreamForUrl("http://baidu.com"))
    println(CrapperDemo.apply.inputStreamForUrlFlatMap("http://baidu.com"))

  }



}
