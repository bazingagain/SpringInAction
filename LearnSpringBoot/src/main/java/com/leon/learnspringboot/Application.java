package com.leon.learnspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created on 15/03/2018.
 *
 * @author Xiaolei-Peng
 *
 * 注意,是在Mybatis配置下,需要使用@Mapper,如果是其它等持久化框架,则照常使用@Repository
 *
 */

/**
 * 1.启动方式1 :
 * @ComponentScan
 * @EnableAutoConfiguration
 *
 * 此种方式 需将使用@Mapper 在映射类上声明,
 * 或在Application上加上@MapperScan("com.leon.learnspringboot.mapper")
 */


/**
 * 2.启动方式2
 * 同样要使用@MapperScan
 */

@SpringBootApplication
@MapperScan("com.leon.learnspringboot.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
