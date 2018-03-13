package com.leon.learncache.config;

import com.leon.learncache.bean.Role;
import com.leon.learncache.dao.RoleDao;
import com.leon.learncache.dao.impl.RoleDaoImpl;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created on 13/03/2018.
 *
 * @author Xiaolei-Peng
 */

//@Configuration
//@EnableCaching
public class RedisCacheConfig {

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        return new RedisCacheManager(redisTemplate);
    }

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }
    @Bean
    public RedisTemplate<Long, Role> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Long, Role> redisTemplate = new RedisTemplate<Long, Role>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new Jackson2JsonRedisSerializer<Long>(Long.class));
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Role>(Role.class));
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean
    public RoleDao roleDao() {
        return new RoleDaoImpl();
    }
}
