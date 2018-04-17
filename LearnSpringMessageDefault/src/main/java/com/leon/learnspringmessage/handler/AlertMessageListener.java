package com.leon.learnspringmessage.handler;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created on 2018/4/16.
 *
 * @author Xiaolei-Peng
 */
public class AlertMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("lintener some message");
    }
}
