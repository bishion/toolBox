package com.bizi.study.service;

import com.bizi.study.model.market.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/applicationContext-*.xml"})
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testSave() throws Exception {

        SysUser sysUser = new SysUser();
        sysUser.setPassword("password");
        sysUser.setUsername("username");

        userService.register(sysUser);
    }
}