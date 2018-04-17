package com.leon.learnspringmessage.service.impl;

import com.leon.learnspringmessage.Model.Spitter;
import com.leon.learnspringmessage.service.ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

/**
 * Created on 2018/4/16.
 *
 * @author Xiaolei-Peng
 */
public class ReceiveServiceImpl implements ReceiveService {

    private JmsTemplate jmsTemplate;

    @Autowired
    public ReceiveServiceImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public Spitter receiveSpittleAlert() {
        // 同步方式接收
        ObjectMessage objectMessage = (ObjectMessage) jmsTemplate.receive();
        try {
            return (Spitter) objectMessage.getObject();
        } catch (JMSException e) {
            //转换成非受检异常
            throw JmsUtils.convertJmsAccessException(e);
        }
    }

    public Spitter receiveSpittleAlertSimple() {
        // 同步方式接收
         return (Spitter) jmsTemplate.receiveAndConvert();

    }
}
