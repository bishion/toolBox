package com.bizi.study.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by guo on 15-3-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring/applicationContext-service.xml")
public class HelloWorldServiceTest {


    @Resource
    private HelloWorldService helloWorldService;

    @Test
    public void testHelloWorld(){
        System.out.println(helloWorldService.helloWorld());
    }

}
