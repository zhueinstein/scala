package com.learn.tryBlock

import java.net.URL

/**
  * Created by admin on 2017/6/26.
  */
case class Customer(age: Int)
class Cigarettes
case class UnderAgeException(message: String) extends Exception(message)
case class UnderAgeFailure(age: Int, required: Int)
object Customer{
    def buyCigarettes(customer: Customer): Cigarettes =
        if (customer.age < 16)
            throw UnderAgeException(s"Customer must be older than 16 but was ${customer.age}")
        else new Cigarettes
    def buyCigarettes2(customer: Customer):Either[UnderAgeFailure, Cigarettes]=
        if(customer.age < 16) Left(UnderAgeFailure(customer.age, 16))
        else Right(new Cigarettes)
    def main(args: Array[String]): Unit = {
        try {
            buyCigarettes(Customer(125))
            println("Yo, here are your cancer sticks! Happy smokin'!")
        }catch {
            case UnderAgeException(msg) => println(msg)
        }
        println(buyCigarettes2(Customer(14)))
    }

    type Citizen = String
    case class BlackResources(url:URL, visitors: Set[Citizen])

    val blackList = List(
        BlackResources(new URL("http://www.baidu.com"),Set("xjp")),
        BlackResources(new URL("http://www.baidu1.com"),Set("xjp1","xjp2","xjp3")),
        BlackResources(new URL("http://www.baidu2.com"),Set.empty),
        BlackResources(new URL("http://www.baidu3.com"),Set("xjp3"))
    )

    val checkedBlackList : List[Either[URL,Set[Citizen]]]=
        blackList.map(resource =>
            if(resource.visitors.isEmpty) Left(resource.url)
            else Right(resource.visitors)
        )
    val suspiciousResources = checkedBlackList.flatMap(_.left.toOption)
    val problemCitizens = checkedBlackList.flatMap(_.right.toOption).flatten.toSet
    problemCitizens.map(println(_))
}
