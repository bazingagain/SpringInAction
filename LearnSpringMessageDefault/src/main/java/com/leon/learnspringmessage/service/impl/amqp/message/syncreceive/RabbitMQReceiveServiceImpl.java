package com.leon.learnspringmessage.service.impl.amqp.message.syncreceive;

import com.leon.learnspringmessage.Model.Spitter;
import com.leon.learnspringmessage.service.RabbitMQReceiveService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 2018/4/18.
 *
 * @author Xiaolei-Peng
 */
public class RabbitMQReceiveServiceImpl implements RabbitMQReceiveService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void receiveSomething() {
        //同步方式
        Spitter spitter = (Spitter) rabbitTemplate.receiveAndConvert("spittle.alert.queue");
    }
}
