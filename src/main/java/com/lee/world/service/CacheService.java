package com.lee.world.service;


import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 测试Java 的cache
 */
@Service
public class CacheService {


    private final static Logger logger = LoggerFactory.getLogger(CacheService.class);

    @Cacheable("trycachecount")
    public Integer getCount(Integer num)
    {
        System.out.println("come in");
        return num++;
    }

    @Cacheable(value="testcache", key="'first_' + #word")
    public Object tryEhCacheData(String word) {
        logger.info("debug : start logic");
        System.out.println("start logic");
        return word;
    }

    @Cacheable(value="testcache", key="'seconde_' + #word")
    public Object tryCachetwo(String word) {
        logger.info("debug : start logic2");
        System.out.println("start logic2");
        return word + "2";
    }

    /**
     * 加上抛出异常的操作，当有异常需要抛出的时候，可以无视该缓存
     * @param word
     * @return
     * @throws Exception
     */
    @Cacheable(value="testcache", key="'three_' + #word")
    public Object tryCacheThree(String word) throws Exception {
        logger.info("debug : start logic3");
        System.out.println("start logic3");
        if (word.equals("exception")) {
            throw new Exception("123");
        }
        return word + "3";
    }
}
