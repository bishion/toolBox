package com.bizi.mybatis.controller;

import com.bizi.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guo on 15-12-28.
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("getUser")
    public String getUser(){
        userService.getUser("bizi");
        return "success";
    }
}
