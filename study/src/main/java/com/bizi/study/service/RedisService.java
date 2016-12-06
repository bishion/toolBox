package com.bizi.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


/**
 * Created by fangbi.guo on 2015/10/28.
 */
@Service
public class RedisService {
	@Autowired
	@Qualifier("redisTemplate")
	private StringRedisTemplate redisTemplate;

	public void getString(){
		for (String s : redisTemplate.keys("*")){
			System.out.println(s+":"+redisTemplate.opsForValue().get(s));
		}
	}
}
