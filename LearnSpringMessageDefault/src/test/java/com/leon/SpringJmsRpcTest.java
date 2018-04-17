package com.leon;

import com.leon.learnspringmessage.service.JmsRpcService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created on 2018/4/17.
 *
 * @author Xiaolei-Peng
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-jms-rpc.xml")
public class SpringJmsRpcTest {

    @Autowired
    private JmsRpcService jmsRpcService;

    @Test
    public void testJmsRPC() {
        jmsRpcService.doSomething();
    }
}
