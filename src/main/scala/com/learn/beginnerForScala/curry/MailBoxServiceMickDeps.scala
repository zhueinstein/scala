package com.learn.beginnerForScala.curry

/**
  * Created by admin on 2017/6/27.
  */
object MailBoxServiceMickDeps extends MailBoxService{
    override val newMails: (User) => Seq[Email] = getNewMails(MockEmailRepository)(MockFilterRepository) _
}
