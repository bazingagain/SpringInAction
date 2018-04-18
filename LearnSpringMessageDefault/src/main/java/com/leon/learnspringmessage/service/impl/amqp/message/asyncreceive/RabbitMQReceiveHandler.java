package com.leon.learnspringmessage.service.impl.amqp.message.asyncreceive;

import com.leon.learnspringmessage.Model.Spitter;

/**
 * Created on 2018/4/18.
 *
 * @author Xiaolei-Peng
 */
public class RabbitMQReceiveHandler {
    public void handleMessage(Spitter spitter) {
        System.out.println("asyn do something");
    }
}
