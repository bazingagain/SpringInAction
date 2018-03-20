package com.leon.springmail.service;

import com.leon.springmail.bean.MailContent;

/**
 * Created on 20/03/2018.
 *
 * @author Xiaolei-Peng
 */
public interface MailSenderService {
    void sendSimpleEmail(String to, MailContent mailContent);
    void sendAttachMail(String to, MailContent mailContent);
    void sendRichMail(String to, MailContent mailContent);

    void sendFreemarkerHtmlMail(String to, MailContent mailContent);
}
