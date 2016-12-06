package com.bizi.study.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by fangbi.guo on 2015/10/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring/application*.xml")
public class RedisServiceTest {
	@Resource
	private RedisService redisService;

	@Test
	public void testRedisService(){
		redisService.getString();
	}
}
