package com.learn.tryCatch

/**
  * Created by zcx on 2017/6/24.
  */
case class Customer(age: Int)
class Cigarettes
case class UnderAgeException(message: String) extends Exception

object Customer{
  def buyCigarettes(customer: Customer): Cigarettes = {
    if (customer.age < 16)
      throw new UnderAgeException(s"Customer must be older than 16 but ${customer.age} ")
    else new Cigarettes
  }

    def main(args: Array[String]): Unit = {
      val youngCustomer = new Customer(15)
      try {
        buyCigarettes(youngCustomer);
      } catch {
        case UnderAgeException(msg) => println(msg)}
    }
}
