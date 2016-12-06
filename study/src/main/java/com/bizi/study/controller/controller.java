package com.bizi.study.controller;

import com.bizi.framework.spring.BaseController;
import com.bizi.study.service.HelloWorldService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by guo on 15-3-16.
 */
@Controller
@RequestMapping(value = "/hello")
public class controller extends BaseController {
    @Resource
    private HelloWorldService helloWorldService;



    @RequestMapping(value = "/world")
    public String testHello(String username, String password) {

        System.out.println("test");
        return "/index.html";
    }




}

