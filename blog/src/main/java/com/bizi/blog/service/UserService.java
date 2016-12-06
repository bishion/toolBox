package com.bizi.blog.service;

import com.bizi.blog.dto.UserInfo;
import com.bizi.blog.model.blog.SysUser;
import com.bizi.blog.consts.ExceptionConst;
import com.bizi.framework.service.BaseDao;
import com.bizi.tools.exception.BaseAppException;
import com.bizi.tools.validate.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by guo on 15-7-28.
 */
@Service
public class UserService {
	@Autowired
	@Qualifier("baseDao_blog")
	private BaseDao<SysUser> userDao;

	public UserInfo login(String username,String password) throws BaseAppException {
		if(ValidateUtil.hasOneNullOrEmpty(username,password)){
			throw new BaseAppException(ExceptionConst.USER_PARAM_HAS_NULL,"用户名或密码为空");
		}

		SysUser sysUser = userDao.get(SysUser.class,username);
		if(ValidateUtil.isNull(sysUser)){
			throw new BaseAppException(ExceptionConst.USER_NOT_EXIST,"用户不存在");
		}
		if(!password.equals(sysUser.getPassword())){
			throw new BaseAppException(ExceptionConst.USER_INFO_ERROR,"用户名或密码错误");
		}
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(sysUser.getUsername());
		return userInfo;
	}

	public void addUser(String username,String password,String realName) throws BaseAppException {
		if(ValidateUtil.hasOneNullOrEmpty(username,password)){
			throw new BaseAppException(ExceptionConst.USER_PARAM_HAS_NULL,"用户名或密码为空");
		}
		SysUser sysUser = new SysUser();
		sysUser.setUsername(username);
		sysUser.setPassword(password);
		sysUser.setRealName(realName);

		SysUser sysUserDB = userDao.get(SysUser.class,username);
		if(ValidateUtil.isNull(sysUserDB)){
			userDao.save(sysUser);
			return;
		}
		throw new BaseAppException(ExceptionConst.USER_HAD_EXIST,"用户已经存在");
	}
}
