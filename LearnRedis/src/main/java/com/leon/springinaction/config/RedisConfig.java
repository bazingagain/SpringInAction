package com.leon.springinaction.config;

import com.leon.springinaction.bean.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created on 06/02/2018.
 *
 * @author Xiaolei-Peng
 */

@Configuration
public class RedisConfig {
    @Bean
    public RedisConnectionFactory redisCF() {
        return new JedisConnectionFactory();
    }

//    @Bean
//    public RedisConnectionFactory redisCF1() {
//        JedisConnectionFactory cf = new JedisConnectionFactory();
//        cf.setHostName("redis-server");
//        cf.setPort(7379);
//        cf.setPassword("foobared");
//        return cf;
//    }

//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
//        RedisTemplate<String, String> redis = new RedisTemplate<String, String>();
//        redis.setConnectionFactory(cf);
//        return redis;
//    }

    @Bean
    public RedisTemplate<String, Product> redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, Product> redis = new RedisTemplate<String, Product>();
        redis.setConnectionFactory(cf);
        return redis;
    }

    //将Product类型的value序列化为JSON,key为String类型
    /**
    @Bean
    public RedisTemplate<String, Product> redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, Product> redis = new RedisTemplate<String, Product>();
        redis.setConnectionFactory(cf);
        redis.setKeySerializer(new StringRedisSerializer());
        redis.setValueSerializer(new Jackson2JsonRedisSerializer<Product>(Product.class));
        return redis;
    }
     **/

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory cf) {
        return new StringRedisTemplate(cf);
    }


}
