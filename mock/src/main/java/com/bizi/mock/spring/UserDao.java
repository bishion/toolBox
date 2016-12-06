package com.bizi.mock.spring;

/**
 * 描述：
 * Created by GuoFangBi on 16-3-10.
 */
public class UserDao implements IUserDao {
    public UserDTO findLoginUser(String username, String password) {
        System.err.println("==============");
        return null;
    }
}
