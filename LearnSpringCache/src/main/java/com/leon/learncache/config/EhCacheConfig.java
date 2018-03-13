package com.leon.learncache.config;

import com.leon.learncache.dao.RoleDao;
import com.leon.learncache.dao.impl.RoleDaoImpl;
import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * Created on 13/03/2018.
 *
 * @author Xiaolei-Peng
 */

@Configuration
@EnableCaching
public class EhCacheConfig {

    @Bean
    public EhCacheCacheManager cacheCacheManager(CacheManager cm) {
        return new EhCacheCacheManager(cm);
    }

    @Bean
    public EhCacheManagerFactoryBean ehcache() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("cache/ehcache.xml"));
        return ehCacheManagerFactoryBean;
    }

    @Bean
    public RoleDao roleDao() {
        return new RoleDaoImpl();
    }

}
