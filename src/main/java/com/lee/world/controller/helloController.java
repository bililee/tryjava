package com.lee.world.controller;

import com.lee.world.service.CacheService;
import com.lee.world.service.RequestService;
import com.lee.world.service.UserService;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lee.world.model.*;


@RestController
public class helloController {


//    @Autowired
//    private static Logger logger = LoggerFactory.getLogger(helloController.class);

    @Autowired
    private CacheService cacheService;


    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping (value = "/hello/{id}",method = RequestMethod.GET)
    public String Hello(@PathVariable Integer id) {
//        logger.info("id" + id);
        User user = userService.query(id);
//        logger.info("1231");
//        logger.info("user" + user.toString());
        String name = user.getName();
        return name;
    }

    @ResponseBody
    @RequestMapping (value = "/sayhello",method = RequestMethod.GET)
    public String SayHello() {
//        logger.info("helolo");
        System.out.println("hello");
        return "hello";
    }


    @ResponseBody
    @RequestMapping (value = "/trycache/{num}",method = RequestMethod.GET)
    public Integer tryCache(@PathVariable Integer num) {
        Integer result = cacheService.getCount(num);
        System.out.println(result);
        return result;
    }

    @ResponseBody
    @RequestMapping (value = "/testPointcut",method = RequestMethod.GET)
    public Integer Pointcut() {

        Integer result = 1;
        System.out.println(result);
        return result;
    }

    @ResponseBody
    @RequestMapping (value = "/trycache2/{word}",method = RequestMethod.GET)
    public Object tryCache(@PathVariable String word) {
        System.out.println(1);
        Object result = cacheService.tryEhCacheData(word);
        System.out.println(result);
        return result;
    }

    @Autowired
    private RequestService requestService;

    @ResponseBody
    @RequestMapping (value="/tryget", method = RequestMethod.GET)
    public Object tryGet() {
        String url = "http://api.k780.com/?app=life.workday&date=20150903&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json";
        return requestService.sendRequestWithGet(url);
    }

    @ResponseBody
    @RequestMapping (value="/tryEhCache", method = RequestMethod.GET)
    public Object tryEhCache(
            @RequestParam("word") String word
    ) {
        return cacheService.tryEhCacheData(word);
    }

    @ResponseBody
    @RequestMapping (value="/tryEhCache2", method = RequestMethod.GET)
    public Object tryEhCache2(
            @RequestParam("word") String word
    ) {
        return cacheService.tryCachetwo(word);
    }
}
