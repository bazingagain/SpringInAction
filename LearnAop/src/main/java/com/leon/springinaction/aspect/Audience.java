package com.leon.springinaction.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created on 21/01/2018.
 *
 * @author Xiaolei-Peng
 */

//@Aspect
public class Audience {

//    @Pointcut("execution(** com.leon.springinaction.Performance.perform(..))")
//    public void performance(){}

//    @Before("execution(** com.leon.springinaction.Performance.perform(..))")
//    @Before("performance()")
    public void silenceCellPhone() {
        System.out.println("Sillence Cell Phone");
    }

//    @Before("execution(** com.leon.springinaction.Performance.perform(..))")
//    @Before("performance()")
    public void taskSeats() {
        System.out.println("Taking seats");
    }

//    @AfterReturning("execution(** com.leon.springinaction.Performance.perform(..))")
//    @AfterReturning("performance()")
    public void applaus() {
        System.out.println("CLAP CLAP CLAP");
    }

//    @AfterThrowing("execution(** com.leon.springinaction.Performance.perform(..))")
//    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }

//    @Around("performance()")
//    public void watchPerformance(ProceedingJoinPoint jp) {
//        try {
//            System.out.println("Sillence Cell Phone");
//            System.out.println("Taking seats");
//            jp.proceed();
//            System.out.println("CLAP CLAP CLAP");
//        } catch (Throwable e) {
//            System.out.println("Demanding a refund");
//        }
//    }
}
