package com.leon.learncache.config;

import com.leon.learncache.dao.RoleDao;
import com.leon.learncache.dao.impl.RoleDaoImpl;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 13/03/2018.
 *
 * @author Xiaolei-Peng
 */

//@Configuration
//@EnableCaching
public class ConcurrentMapCacheConfig {
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }

    @Bean
    public RoleDao roleDao() {
        return new RoleDaoImpl();
    }
}
