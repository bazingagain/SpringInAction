package com.leon.springinaction.config;

import com.leon.springinaction.controller.SpittleController;
import com.leon.springinaction.dao.SpittleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * Created on 22/02/2018.
 *
 * @author Xiaolei-Peng
 */

@Configuration
@ImportResource("classpath:spring.xml")
@ComponentScan(basePackages = "com.leon.springinaction")
public class JavaConfig {

    @Bean
    public SpittleRepository spittleRepository() {
        return new SpittleRepository();
    }

//    @Bean
//    public SpittleController spittleController(SpittleRepository spittleRepository) {
//        return new SpittleController(spittleRepository);
//    }

    @Bean
    public ViewResolver cnViewResolver() {
        return new ContentNegotiatingViewResolver();
    }

    @Bean
    public ViewResolver cnViewResolver(ContentNegotiationManager cnm) {
        ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
        viewResolver.setContentNegotiationManager(cnm);
        return viewResolver;
    }

    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.TEXT_HTML);
    }

    @Bean
    public ViewResolver beanNameViewResolver() {
        return new BeanNameViewResolver();
    }

    @Bean
    public View spittles() {
        return new MappingJackson2JsonView();
    }

}
