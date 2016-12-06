package com.bizi.blog.dto;

/**
 * Created by guo on 15-7-24.
 */
public class CategoryArtDTO {
	private String category;
	private String path;
	private Integer number;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
