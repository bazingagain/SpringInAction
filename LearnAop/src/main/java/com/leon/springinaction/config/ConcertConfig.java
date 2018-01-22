package com.leon.springinaction.config;

import com.leon.springinaction.Performance;
import com.leon.springinaction.aspect.Audience;
import com.leon.springinaction.aspect.EncoreableIntroducer;
import com.leon.springinaction.impl.PerformanceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created on 21/01/2018.
 *
 * @author Xiaolei-Peng
 */
@Configuration
@EnableAspectJAutoProxy
//@ComponentScan
public class ConcertConfig {

    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean
    public EncoreableIntroducer encoreableIntroducer() {
        return new EncoreableIntroducer();
    }

    @Bean
    public Performance performance() {return new PerformanceImpl();}


}
