package com.lee.world.config;


import net.sf.ehcache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class CacheConfig {

//    @Bean
//    public CacheManager cacheManager() {
//        return new ConcurrentMapCacheManager();
//
//    }

    /**
     * 默认设置一个EhCache
     * @return
     */
    @Bean
    public net.sf.ehcache.CacheManager ehCacheManager() {
        net.sf.ehcache.CacheManager cacheManager = net.sf.ehcache.CacheManager.newInstance();
        Cache cache = new Cache("testcache", 1000, false, false, 20, 20);
        cacheManager.addCache(cache);
        return cacheManager;
    }

    @Bean
    public org.springframework.cache.CacheManager springCacheManger() {
        return new EhCacheCacheManager(ehCacheManager());
    }

}
