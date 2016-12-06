package com.bizi.blog.service;

import com.bizi.tools.exception.BaseAppException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by guo on 15-7-28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring/applicationContext-*.xml")
public class UserServiceTest {
	@Resource
	private UserService userService;
	@Test
	public void insertArticleTest(){

		try {
			userService.addUser("Bishion","123456","碧子");
		} catch (BaseAppException e) {
			e.printStackTrace();
		}
	}


}