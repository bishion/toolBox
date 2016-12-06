package com.bizi.study.service;

import com.bizi.framework.service.BaseDao;
import com.bizi.study.model.market.SysUser;
import com.bizi.tools.exception.BaseAppException;
import com.bizi.tools.validate.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guo on 15-3-20.
 */
@Service
public class UserService {
    @Autowired
    @Qualifier("baseDao_market")
    private BaseDao<SysUser> userDao;

    public List<SysUser> login(String username,String password) throws BaseAppException {
        SysUser sysUser = userDao.get(SysUser.class, username);

        if(ValidateUtil.isNull(sysUser)||ValidateUtil.isBlank(sysUser.getUsername())){
            throw new BaseAppException("LGN0001","没有此用户");
        }
        if(sysUser.getPassword().equals(password)){
            return userDao.loadAll(SysUser.class);
        }
        throw new BaseAppException("LGN0002","用户名或密码错误");
    }
    public void register(SysUser user) throws BaseAppException {
        SysUser sysUser = userDao.get(SysUser.class, user.getOpenId());

        if(ValidateUtil.isNull(sysUser)||ValidateUtil.isBlank(sysUser.getUsername())){
            userDao.save(user);
        }else{
            throw new BaseAppException("LGN0003","该用户已存在");
        }

    }

    public SysUser getSysUser(String username){
        return userDao.get(SysUser.class, username);
    }
    public List<SysUser> getUserList(){
        return userDao.loadAll(SysUser.class);
    }
}
