package com.bizi.mybatis.service;

import com.bizi.mybatis.dao.IUserDao;
import com.bizi.mybatis.model.blog.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fangbi.guo on 2015/9/28.
 */
@Service
public class UserService {
	@Autowired
	private IUserDao userDao;

	public void getUser(String username){
		SysUser sysUser = userDao.queryById(username);
		System.out.println(sysUser.getUsername());
	}
}
