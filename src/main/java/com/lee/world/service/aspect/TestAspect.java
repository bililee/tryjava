package com.lee.world.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestAspect {

    private final static Logger logger = LoggerFactory.getLogger(TestAspect.class);

    @Pointcut("execution(public * com.lee.world.controller.*.*(..))")
    public void Pointcut() {

    }

    @Before("Pointcut()")
    public void before()
    {
        logger.info("pointcut before");
    }

    @Around("Pointcut()")
    public void aroud(ProceedingJoinPoint jp)
    {
        logger.info("aroud");
        try {
            jp.proceed();
        } catch (Throwable exp) {

        }
        logger.info("aroud after");


    }
}
