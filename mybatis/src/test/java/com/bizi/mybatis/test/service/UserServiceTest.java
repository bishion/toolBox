package com.bizi.mybatis.test.service;

import com.bizi.mybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by fangbi.guo on 2015/9/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/spring/*.xml")
public class UserServiceTest {
	@Autowired
	private UserService userService;
	@Test
	public void testQueryById(){
		userService.getUser("bizi");
	}
}
