package com.leon;

import static org.junit.Assert.assertTrue;

import com.leon.learnspringmessage.Model.Spitter;
import com.leon.learnspringmessage.service.AlertService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-message.xml")
public class SpringMessageTest
{
    @Autowired
    private AlertService alertService;

//    @Autowired
//    private ReceiveService receiveService;

    @Test
    public void test() {
        alertService.sendSpitterAlert(new Spitter());
    }
}
