package com.bizi.study.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by guo on 15-3-16.
 */
@Service
public class HelloWorldService implements IHelloWorldService {
    @Override
    public String helloWorld() {
        System.out.println("hello Service");
        return "Hello world";
    }
    public void addUser(){
        System.out.println("添加用户");
        updateReport();
    }
    public void updateReport(){
        System.out.println("修改用户人数");
    }


}
