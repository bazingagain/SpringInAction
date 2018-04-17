package com.leon.learnspringmessage.service.impl;

import com.leon.learnspringmessage.service.JmsRpcService;
import org.springframework.stereotype.Component;

/**
 * Created on 2018/4/17.
 *
 * @author Xiaolei-Peng
 */

public class JmsRpcServiceImpl implements JmsRpcService {

    @Override
    public void doSomething() {
        System.out.println("rpc recevie message");
    }
}
