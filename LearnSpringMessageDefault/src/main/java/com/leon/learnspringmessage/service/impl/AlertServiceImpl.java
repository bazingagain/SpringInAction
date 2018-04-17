package com.leon.learnspringmessage.service.impl;

import com.leon.learnspringmessage.Model.Spitter;
import com.leon.learnspringmessage.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created on 2018/4/16.
 *
 * @author Xiaolei-Peng
 */

public class AlertServiceImpl implements AlertService {

    private JmsTemplate jmsTemplate;

    @Autowired
    public AlertServiceImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendSpitterAlert(final Spitter spitter) {
        jmsTemplate.send("spittle.alert.queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(spitter);
            }
        });
    }

    public void sendSpitterAlertSimple(final Spitter spitter) {
        //使用内置的MessageConverter
        jmsTemplate.convertAndSend(spitter);
    }
}
