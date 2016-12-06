package com.csnt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by guo on 15-3-17.
 */
@Controller
@RequestMapping("/hello")
public class FirstController {

    @RequestMapping(method = RequestMethod.GET,value = "/home")
    public String testFirst(){
        System.out.println("Hello world");
        return "Hello world";
    }
}
