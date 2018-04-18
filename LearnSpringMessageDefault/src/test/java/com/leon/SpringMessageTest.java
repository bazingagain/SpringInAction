package com.leon;

import static org.junit.Assert.assertTrue;

import com.leon.learnspringmessage.Model.Spitter;
import com.leon.learnspringmessage.service.JmsMessageSendService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:jms-message/spring-message.xml")
public class SpringMessageTest
{
    @Autowired
    private JmsMessageSendService jmsMessageSendService;

//    @Autowired
//    private JmsMessageReceiveService receiveService;

    @Test
    public void test() {
        jmsMessageSendService.sendSpitterAlert(new Spitter());
    }
}
