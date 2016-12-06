package com.bizi.mybatis.dao;

import com.bizi.mybatis.model.blog.SysUser;

/**
 * Created by fangbi.guo on 2015/9/28.
 */
public interface IUserDao {
	public SysUser queryById(String useranem);
}
