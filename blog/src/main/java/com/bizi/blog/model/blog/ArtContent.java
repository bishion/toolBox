package com.bizi.blog.model.blog;

/**
 * Created by guo on 15-7-28.
 */
public class ArtContent {
	private Integer id;
	private String content;
	private Article article;

	public ArtContent() {
	}

	public ArtContent(String content) {
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
}
