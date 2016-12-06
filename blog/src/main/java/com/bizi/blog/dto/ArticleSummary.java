package com.bizi.blog.dto;

/**
 * Created by guo on 15-7-24.
 */
public class ArticleSummary {
	private String createDate;
	private String path;
	private String title;

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
