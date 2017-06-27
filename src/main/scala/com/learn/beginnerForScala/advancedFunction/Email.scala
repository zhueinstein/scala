package com.learn.beginnerForScala.advancedFunction

/**
  * Created by admin on 2017/6/26.
  */
case class Email(subject: String,
                 text: String,
                 sender: String,
                 recipient: String)

object Email{
    type EmailFilter = Email => Boolean

    def newMailsForUser(mails: Seq[Email], f:EmailFilter) = mails.filter(f)

    val sentByOneOf: Set[String] => EmailFilter =
        senders =>
            email =>senders.contains(email.sender)
//    val notSentByAnyOf: Set[String] => EmailFilter =
//        senders =>
//            email => !senders.contains(email.sender)
    /** 函数组合
      * 补函数
      * @param predicate
      * @tparam A
      * @return
      */
    def complement[A](predicate: A => Boolean) = (a: A) => !predicate(a)
    val notSentByAnyOf = sentByOneOf andThen (g => complement(g))
    val minimumSize: Int => EmailFilter =
        n =>
            sizeConstraint( _ > n)
//            email => email.text.size >= n
    val maximumSize: Int => EmailFilter =
        n =>
            sizeConstraint(_ < n)
//            email => email.text.size <= n

    type SizeChecker = Int => Boolean

    val sizeConstraint:SizeChecker => EmailFilter =
            f =>
                email => f(email.text.size)

    def any[A](predicates:(A => Boolean)*):A =>Boolean = a => predicates.exists(pred => pred(a))
    def none[A](predicates:(A => Boolean) *): A => Boolean = complement(any(predicates: _*))
    def every[A](predicates:(A => Boolean)*):A =>Boolean = none(predicates.view.map(complement(_)):_*)

    def main(args: Array[String]): Unit = {
        val emailSender: EmailFilter = notSentByAnyOf(Set("job@51.com"))
        val mails = Email(
            "Glad to see you",
            "This was my best day",
            "job@51.com",
            "码云"
        )::Nil
        newMailsForUser(mails, emailSender).map(u => println(u.recipient))
//        val every = every{
//            maximumSize(1100)
//            minimumSize(15)
//        }
        val sizeChecker:EmailFilter = maximumSize(100)

        newMailsForUser(mails, sizeChecker).map(u => println(u.text))
//        newMailsForUser(mails, every).map(u => println(u.text))
    }

}
