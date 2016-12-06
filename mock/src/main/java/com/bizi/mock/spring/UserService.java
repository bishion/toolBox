package com.bizi.mock.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述：
 * Created by GuoFangBi on 16-3-10.
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserDao userDao;

    /**
     * 登陆类，传入用户名密码，返回登陆对象。
     * 在开发过程中，如果userDao为远程HSF服务，则很有可能出现调用不到的情况，
     * 因此单元测试希望只调试login方法的业务逻辑，而不想关心userDao的逻辑。
     */
    public UserDTO login(String username, String password) {
        UserDTO userDTO = userDao.findLoginUser(username,password);
        // Balabala。。。
        return userDTO;
    }
}
