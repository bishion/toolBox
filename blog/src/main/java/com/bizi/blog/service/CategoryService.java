package com.bizi.blog.service;

import com.bizi.blog.model.blog.Category;
import com.bizi.framework.service.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guo on 15-7-25.
 */
@Service
public class CategoryService {
	@Autowired
	@Qualifier("baseDao_blog")
	private BaseDao<Category> categoryDao;

	public void saveCategory(Category category){
		categoryDao.save(category);
		categoryDao.getCurrentSession().flush();
	}
	public List<Category> getAllCategorys(){
		return categoryDao.loadAll(Category.class);
	}

}
