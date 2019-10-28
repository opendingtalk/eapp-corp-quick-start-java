package com.dadapro.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author Administrator
 * @date 2019-10-21
 */
@Configuration
@EnableCaching
public class GuavaConfig {

    @Bean
    public CacheManager getCacheManager() {
        GuavaCacheManager cacheManager = new GuavaCacheManager();

        //最多缓存500 条
        cacheManager.setCacheSpecification("maximumSize=500,expireAfterWrite=1111111120m");
        //GuavaCacheManager 的数据结构类似  Map<String,Map<Object,Object>>  map =new HashMap<>();
        return cacheManager;
    }
}
