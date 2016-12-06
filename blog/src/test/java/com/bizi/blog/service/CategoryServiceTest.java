package com.bizi.blog.service;

import com.bizi.blog.model.blog.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by guo on 15-7-25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring/applicationContext-*.xml")
public class CategoryServiceTest {
	@Resource
	private CategoryService categoryService;
	@Test
	public void insertCategory(){
		Category category = new Category();
		category.setCode("exception1");
		category.setName("异常报错");

		categoryService.saveCategory(category);
	}
}
