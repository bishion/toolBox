package com.bizi.blog.dto;

/**
 * Created by guo on 15-7-25.
 */
public class CategoryDTO {
	private String code;
	private String name;

	public CategoryDTO(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public CategoryDTO() {
	}

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
}
