package com.bizi.blog.service;

import com.bizi.blog.dto.ArticleSummary;
import com.bizi.blog.dto.CategoryArtDTO;
import com.bizi.tools.date.DateUtil;
import com.bizi.tools.json.JsonMapper;
import org.junit.Test;

import java.util.*;

/**
 * Created by guo on 15-7-24.
 */
public class MakeDataTest {
	@Test
	public void getArticlesTest(){
		List<ArticleSummary> articles = new ArrayList<ArticleSummary>();

		ArticleSummary articleSummary1 = new ArticleSummary();
		articleSummary1.setTitle("测试标题1");
		articleSummary1.setPath("/baidu/baidu1.html");
		articleSummary1.setCreateDate(DateUtil.toString(new Date(), DateUtil.YYYYsMMsDD));

		ArticleSummary articleSummary2 = new ArticleSummary();
		articleSummary2.setTitle("测试标题2");
		articleSummary2.setPath("/baidu/baidu2.html");
		articleSummary2.setCreateDate(DateUtil.toString(new Date(), DateUtil.YYYYsMMsDD));

		ArticleSummary articleSummary3 = new ArticleSummary();
		articleSummary3.setTitle("测试标题3");
		articleSummary3.setPath("/baidu/baidu3.html");
		articleSummary3.setCreateDate(DateUtil.toString(new Date(), DateUtil.YYYYsMMsDD));

		articles.add(articleSummary1);
		articles.add(articleSummary2);
		articles.add(articleSummary3);

		System.out.println(JsonMapper.toNormalJson(articles));
	}
	@Test
	public void getCategorysTest(){
		List<CategoryArtDTO> articles = new ArrayList<CategoryArtDTO>();

		CategoryArtDTO categoryArtDTO1 = new CategoryArtDTO();
		categoryArtDTO1.setCategory("测试分类1");
		categoryArtDTO1.setPath("/baidu/baidu1.html");
		categoryArtDTO1.setNumber(100);

		CategoryArtDTO categoryArtDTO2 = new CategoryArtDTO();
		categoryArtDTO2.setCategory("测试分类2");
		categoryArtDTO2.setPath("/baidu/baidu2.html");
		categoryArtDTO2.setNumber(100);

		CategoryArtDTO categoryArtDTO3 = new CategoryArtDTO();
		categoryArtDTO3.setCategory("测试分类3");
		categoryArtDTO3.setPath("/baidu/baidu3.html");
		categoryArtDTO3.setNumber(100);

		articles.add(categoryArtDTO1);
		articles.add(categoryArtDTO2);
		articles.add(categoryArtDTO3);

		System.out.println(JsonMapper.toNormalJson(articles));
	}

	@Test
	public void getCategoryArtsTest(){
		Map<String,List<ArticleSummary>> articleSummaryMap = new HashMap();

		List<ArticleSummary> articles = new ArrayList<ArticleSummary>();

		ArticleSummary articleSummary1 = new ArticleSummary();
		articleSummary1.setTitle("测试标题1");
		articleSummary1.setPath("/baidu/baidu1.html");
		articleSummary1.setCreateDate(DateUtil.toString(new Date(), DateUtil.YYYYsMMsDD));

		ArticleSummary articleSummary2 = new ArticleSummary();
		articleSummary2.setTitle("测试标题2");
		articleSummary2.setPath("/baidu/baidu2.html");
		articleSummary2.setCreateDate(DateUtil.toString(new Date(), DateUtil.YYYYsMMsDD));

		ArticleSummary articleSummary3 = new ArticleSummary();
		articleSummary3.setTitle("测试标题3");
		articleSummary3.setPath("/baidu/baidu3.html");
		articleSummary3.setCreateDate(DateUtil.toString(new Date(), DateUtil.YYYYsMMsDD));

		articles.add(articleSummary1);
		articles.add(articleSummary2);
		articles.add(articleSummary3);

		articleSummaryMap.put("test", articles);

		System.out.println(JsonMapper.toNormalJson(articleSummaryMap));

		Map<String ,String> categoryNameMap = new HashMap<>();
		categoryNameMap.put("test","测试");
		System.out.println(JsonMapper.toNormalJson(categoryNameMap));
	}
}
