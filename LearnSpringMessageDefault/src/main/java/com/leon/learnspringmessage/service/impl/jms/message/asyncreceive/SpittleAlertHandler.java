package com.leon.learnspringmessage.service.impl.jms.message.asyncreceive;

import com.leon.learnspringmessage.Model.Spitter;

/**
 * Created on 2018/4/16.
 *
 * @author Xiaolei-Peng
 */
public class SpittleAlertHandler {
    public void handleSpittleAlert(Spitter spitter) {
        System.out.println("do something");
    }
}
