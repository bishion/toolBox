package com.bizi.blog.model.blog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guo on 15-7-25.
 */
public class Category {
	private String code;
	private String name;
	private List<Article> articleList = new ArrayList<>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
}
