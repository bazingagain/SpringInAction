package com.leon.springinaction.impl;

import com.leon.springinaction.Performance;
import org.springframework.stereotype.Component;

/**
 * Created on 21/01/2018.
 *
 * @author Xiaolei-Peng
 */

@Component
public class PerformanceImpl implements Performance {
    public void perform() {
        System.out.println("call performimpl perform");
    }

}
