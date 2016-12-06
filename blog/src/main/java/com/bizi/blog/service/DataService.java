package com.bizi.blog.service;

import com.bizi.blog.dto.ArticleSummary;
import com.bizi.blog.dto.CategoryArtDTO;
import com.bizi.blog.model.blog.Article;
import com.bizi.blog.model.blog.Category;
import com.bizi.blog.consts.BaseConst;
import com.bizi.tools.bean.BeanUtil;
import com.bizi.tools.date.DateUtil;
import com.bizi.tools.json.JsonMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guo on 15-7-25.
 */
@Service
public class DataService {
	@Resource
	private CategoryService categoryService;

	@Resource
	private ArticleService articleService;

	public void asyncData(){
		// 1. 封装最新文章列表
		List<Article> latestArticle = articleService.getTopArticles();
		List<ArticleSummary> latestArticleSummary = new ArrayList<>();
		for(Article article : latestArticle){
			ArticleSummary articleSummary = new ArticleSummary();
			BeanUtil.copyProperties(article, articleSummary);
			articleSummary.setCreateDate(DateUtil.toString(article.getCreateDate(), DateUtil.yyyy_MM_dd));

			latestArticleSummary.add(articleSummary);
		}

		// . 封装category列表
		List<CategoryArtDTO> categoryArtDTOList = new ArrayList<>();
		// 3. 封装按category分类后的文章列表
		Map<String,List<ArticleSummary>> categoryArtMap = new HashMap<>();
		// 4. 封装所有的category 以供加载
		Map<String,String> categoryMap = new HashMap<>();
		List<Category> categoryList = categoryService.getAllCategorys();
		for(Category category : categoryList){
			// 2.1 组装category列表数据
			CategoryArtDTO categoryArtDTO = new CategoryArtDTO();
			categoryArtDTO.setNumber(category.getArticleList().size());
			categoryArtDTO.setPath(BaseConst.CATEGORY_HTML_PATH + category.getCode());
			categoryArtDTO.setCategory(category.getName());

			categoryArtDTOList.add(categoryArtDTO);

			// 3.1 拼装同一category下的article列表,放在List<ArticleDTO>下,然后以category为key,塞到map中
			// 3.1.1封装同一category下的article
			List<ArticleSummary> articleSummaryList = new ArrayList<>();
			List<Article> articleList = category.getArticleList();
			for (Article article :articleList){
				ArticleSummary articleSummary = new ArticleSummary();
				BeanUtil.copyProperties(article,articleSummary);
				articleSummary.setCreateDate(DateUtil.toString(article.getCreateDate(),DateUtil.yyyy_MM_dd));
				articleSummaryList.add(articleSummary);
			}
			// 3.1.2 article列表放入map中
			categoryArtMap.put(category.getCode(),articleSummaryList);

			// 4.1 将category放入map中
			categoryMap.put(category.getCode(),category.getName());
		}

		String latest_art   = "var latest_art = " 	+ JsonMapper.toNormalJson(latestArticleSummary)	+ ";\n";
		String categories   = "var categories = " 	+ JsonMapper.toNormalJson(categoryArtDTOList)	+ ";\n";
		String category_art = "var category_art = "	+ JsonMapper.toNormalJson(categoryArtMap)		+ ";\n";
		String category_map = "var category_map = "	+ JsonMapper.toNormalJson(categoryMap)			+ ";\n";


		File htmlFile = new File("/blog/data/all_data.js");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(htmlFile));
			bw.write(latest_art+categories+category_art+category_map);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
