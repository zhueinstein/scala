package com.learn.tryBlock

import java.io.InputStream
import java.net.URL

import scala.io.Source
import scala.util.{Failure, Success, Try}

/**
  * Created by admin on 2017/6/26.
  */
class TryParseURL {
    def parseURL(url:String):Try[URL] = Try(new URL(url))

    def parseInputStream(url: String):Try[Try[Try[InputStream]]] = parseURL(url).map{
        u => Try(u.openConnection()).map(coon => Try(coon.getInputStream))
    }

    def parseInputStreamForURL(url:String):Try[InputStream] = parseURL(url).flatMap{
        u => Try(u.openConnection()).flatMap(conn => Try(conn.getInputStream))
    }

    def parseHttpUrl(url:String) = parseURL(url).filter(_.getProtocol() == "http")

    def getUrlContent(url:String):Try[Iterator[String]] =
        for {
            url <- parseURL(url)
            connection <- Try(url.openConnection())
            is <- Try(connection.getInputStream)
            source = Source.fromInputStream(is)
        } yield source.getLines()
}

object TryParseURL{
    def apply: TryParseURL = new TryParseURL()
    def main(args: Array[String]): Unit = {
        println(TryParseURL.apply.parseURL("http://aa"))
        println(TryParseURL.apply.parseInputStream("http://baidu.com"))
        println(TryParseURL.apply.parseInputStreamForURL("http://baodu.com"))
        TryParseURL.apply.parseHttpUrl("http://baodu.com").foreach(println)
        TryParseURL.apply.getUrlContent("http://baidu.com").foreach(println)
        TryParseURL.apply.getUrlContent("https://www.baidu.com/") match {
            case Success(lines) => lines.foreach(println)
            case Failure(ex) => println(s"Problem rendering URL content: ${ex.getMessage}")
        }

    }
}
