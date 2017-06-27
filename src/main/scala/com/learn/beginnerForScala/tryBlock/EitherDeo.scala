package com.learn.beginnerForScala.tryBlock

import java.net.URL

import scala.io.Source

/**
  * Created by admin on 2017/6/26.
  */
class EitherDeo {
    def getContent(url:URL):Either[String, Source] =
        if(url.getHost.contains("google"))
            Left("Requested URL is blocked for the good of the people!")
        else
            Right(Source.fromURL(url))

    def avgCount(url1: URL, url2: URL)={
        for{
            source1 <- getContent(url1).right
            source2 <- getContent(url2).right
        } yield (source1.getLines().size + source2.getLines().size)/2
    }
    def averageLineCountWontCompile(url1: URL, url2: URL): Either[String, Int] =
        for {
            source1 <- getContent(url1).right
            source2 <- getContent(url2).right
            lines1 = source1.getLines().size
            lines2 = source2.getLines().size
        } yield (lines1 + lines2) / 2
}

object EitherDeo{
    def apply: EitherDeo = new EitherDeo()

    def main(args: Array[String]): Unit = {
        println(apply.getContent(new URL("https://google.cn")))
        apply.getContent(new URL("https://google.cn")) match {
            case Left(msg) => println(msg)
            case Right(source) => source.getLines().foreach(println)
        }

        val content: Either[String, Iterator[String]] =
            apply.getContent(new URL("http://blog.csdn.net/shenxiaoming77/article/details/51491448")).right.map(_.getLines())
       content.foreach(println)

        val part5 = new URL("http://blog.csdn.net/shenxiaoming77/article/details/51491448")
        val part6 = new URL("http://blog.csdn.net/u010257992/article/details/52474639")

        val content1 = apply.getContent(part5).right.map( a => apply.getContent(part6).right.map(b => (a.getLines().size + b.getLines().size)/2))
        println(s"avg size $content1")

        val content2 = apply.getContent(part5).right.flatMap(a => apply.getContent(part6).right.map((b =>(a.getLines().size + b.getLines().size)/2)))
        println(s"content2 is $content2")
        println(apply.avgCount(part5, part6))
        println(apply.averageLineCountWontCompile(part5, part6))
    }
}
