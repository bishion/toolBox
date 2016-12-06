package com.bizi.blog.service;

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
public class ArtContentServiceTest {
	@Resource
	private ArtContentService artContentService;

	@Test
	public void addContent(){
		artContentService.addContent("test");
	}

}
