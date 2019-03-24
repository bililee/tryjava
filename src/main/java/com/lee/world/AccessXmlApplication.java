package com.lee.world;

import com.lee.world.service.TestXmlService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class AccessXmlApplication {
    public static void main(String[] args)
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        TestXmlService tx = (TestXmlService) ac.getBean("testxml");
        System.out.println(tx.helloXml());
        System.out.println("helloworld");
    }
}
