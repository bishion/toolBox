package com.bizi.blog.service;

import com.bizi.blog.model.blog.Article;
import com.bizi.blog.model.blog.Category;
import com.bizi.blog.utils.ArticleUtil;
import com.bizi.blog.dto.ArticleDTO;
import com.bizi.blog.model.blog.ArtContent;
import com.bizi.framework.service.BaseDao;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by guo on 15-7-22.
 */
@Service
public class ArticleService {
	@Autowired
	@Qualifier("baseDao_blog")
	private BaseDao<Article> articleDao;

	@Autowired
	private DataService dataService;
	@Autowired
	@Qualifier("baseDao_blog")
	private BaseDao<Category> categoryDao;
	public void insertArticle(ArticleDTO articleDTO){
		Article article = new Article();
		Category category = categoryDao.get(Category.class,articleDTO.getCategory());
		article.setAuthor(articleDTO.getAuthor());
		article.setCategory(category);
		article.setCreateDate(new Date());
		article.setSummary(articleDTO.getSummary());
		article.setTitle(articleDTO.getTitle());
		article.setPath(articleDTO.getCategory() + "/" + articleDTO.getFileName() + ".html");
		article.setIndex(category.getArticleList().size());

		ArtContent artContent = new ArtContent(articleDTO.getContent());
		artContent.setArticle(article);
		article.setContent(artContent);

		articleDao.save(article);

		String articleStr = ArticleUtil.getArticle(articleDTO);
		String htmlParentPath = "/blog/"+articleDTO.getCategory();
		File htmlParentDir = new File(htmlParentPath);
		if(!htmlParentDir.exists() && !htmlParentDir.isDirectory()){
			htmlParentDir.mkdir();
		}
		File htmlFile = new File("/blog/"+articleDTO.getCategory()+"/"+articleDTO.getFileName()+".html");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(htmlFile));
			bw.write(articleStr);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		articleDao.flush();
		// 同步data
		//dataService.asyncData();
	}

	//@Transactional("txProxyTemplate_blog")
	public List<Article> getTopArticles(){
		Query query = articleDao.getSessionFactory().openSession().createQuery(" from com.bizi.blog.model.blog.Article");
		query.setFirstResult(0);
		query.setMaxResults(20);
		return query.list();
	}
}
