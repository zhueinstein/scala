package com.learn.beginnerForScala.curry

/**
  * Created by admin on 2017/6/27.
  */
trait MailBoxService {
    def getNewMails(emailRepository: EmailRepository)(filterRepository: FilterRepository)(user: User) =
        emailRepository.getMails(user, true).filter(filterRepository.getEmailFilter(user))

    val newMails: User =>Seq[Email]
}
