package com.bizi.blog.controller;

import com.bizi.blog.dto.CategoryDTO;
import com.bizi.blog.model.blog.Category;
import com.bizi.blog.service.CategoryService;
import com.bizi.framework.spring.BaseController;
import com.bizi.tools.log.LogUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guo on 15-7-25.
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController extends BaseController{
	@Resource
	private CategoryService categoryService;

	@RequestMapping(value = "/list.do")
	public void listAllCategorys(){
		try{
			List<Category> categories = categoryService.getAllCategorys();
			List<CategoryDTO> categoryDTOList = new ArrayList<>();
			for(Category category:categories){
				CategoryDTO categoryDTO = new CategoryDTO(category.getCode(),category.getName());

				categoryDTOList.add(categoryDTO);
			}
			this.writeObjResponse(categoryDTOList);
		}catch (Exception e){
			LogUtil.error(logger,"查询category列表",e);
		}

	}

	@RequestMapping("/create.do")
	private String createCategory(String code,String name){
		LogUtil.info(logger,"category新增","code",code,"name",name,"请求新增");
		Category category = new Category();
		category.setCode(code);
		category.setName(name);

		categoryService.saveCategory(category);

		return "redirect:/write_article.html";
	}

}
