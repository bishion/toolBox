package com.bizi.blog.service;


import com.bizi.blog.dto.ArticleDTO;
import com.bizi.blog.model.blog.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by guo on 15-7-22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring/applicationContext-*.xml")
public class ArticleServiceTest {
	@Resource
	private ArticleService articleService;
	@Test
	public void insertArticleTest(){
		ArticleDTO articleDTO = new ArticleDTO();
		articleDTO.setTitle("Title");
		articleDTO.setSummary("Summary");
		articleDTO.setCreateDate(new Date());
		articleDTO.setCategory("category");
		articleDTO.setAuthor("Author");
		articleDTO.setFileName("FileName");
		articleDTO.setContent("Content");
		articleService.insertArticle(articleDTO);
		System.out.println("Hello World");
	}

	@Test
	public void getTopArticlesTest(){
		List<Article> articleList = articleService.getTopArticles();
		System.out.println(articleList.size());
	}

}
