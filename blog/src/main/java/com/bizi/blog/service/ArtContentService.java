package com.bizi.blog.service;

import com.bizi.blog.model.blog.ArtContent;
import com.bizi.framework.service.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by guo on 15-7-28.
 */
@Service
public class ArtContentService {
	@Autowired
	@Qualifier("baseDao_blog")
	private BaseDao<ArtContent> contentDao;

	public void addContent(String content){
		ArtContent artContent = new ArtContent();
		artContent.setContent(content);
		contentDao.save(artContent);
	}
}
