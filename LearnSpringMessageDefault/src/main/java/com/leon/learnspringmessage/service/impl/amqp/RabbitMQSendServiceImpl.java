package com.leon.learnspringmessage.service.impl.amqp;

import com.leon.learnspringmessage.service.RabbitMQSendService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 2018/4/18.
 *
 * @author Xiaolei-Peng
 */
public class RabbitMQSendServiceImpl implements RabbitMQSendService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendSomething() {
        //Exchange名称,routing key以及要发送的对象
        //convertAndSend默认使用SimpleMessageConverter,可以使用xml等设置converter
        rabbitTemplate.convertAndSend("spittle.alert.exchange", "spittle.alerts.queue.2", "要发送的消息");

        //在rabbitTemplate配置了默认的exchange,queue,routerkey的话,直接可以发送信息
        rabbitTemplate.convertAndSend("要发送的消息");
    }
}
