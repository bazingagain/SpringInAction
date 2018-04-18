package com.leon.learnspringmessage.service;

import com.leon.learnspringmessage.Model.Spitter;

/**
 * Created on 2018/4/16.
 *
 * @author Xiaolei-Peng
 */
public interface JmsMessageSendService {
    void sendSpitterAlert(Spitter spitter);
}
