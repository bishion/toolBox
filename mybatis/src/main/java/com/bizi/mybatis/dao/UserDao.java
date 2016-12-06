package com.bizi.mybatis.dao;

import com.bizi.mybatis.model.blog.SysUser;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fangbi.guo on 2015/9/28.
 */
@Service
public class UserDao implements IUserDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public SysUser queryById(String username) {
		return (SysUser) sqlSessionTemplate.selectOne("queryById", username);
	}
}
