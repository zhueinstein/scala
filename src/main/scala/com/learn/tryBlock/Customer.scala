package com.learn.tryBlock

/**
  * Created by admin on 2017/6/26.
  */
case class Customer(age: Int)
class Cigarettes
case class UnderAgeException(message: String) extends Exception(message)
object Customer{
    def buyCigarettes(customer: Customer): Cigarettes =
        if (customer.age < 16)
            throw UnderAgeException(s"Customer must be older than 16 but was ${customer.age}")
        else new Cigarettes

    def main(args: Array[String]): Unit = {
        try {
            buyCigarettes(Customer(125))
            println("Yo, here are your cancer sticks! Happy smokin'!")
        }catch {
            case UnderAgeException(msg) => println(msg)
        }
    }
}
