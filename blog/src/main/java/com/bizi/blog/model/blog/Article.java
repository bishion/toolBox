package com.bizi.blog.model.blog;

import java.util.Date;

/**
 * Created by guo on 15-7-22.
 */
public class Article {
	private Integer		id;
	private String		title;
	private Category	category;
	private String		author;
	private String		summary;
	private String		path;
	private Date		createDate;
	private Integer		index;
	private ArtContent	content;

	public ArtContent getContent() {
		return content;
	}

	public void setContent(ArtContent content) {
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
}
