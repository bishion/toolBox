package com.bizi.mock.spring;

/**
 * 描述：
 * Created by GuoFangBi on 16-3-8.
 */
public interface IUserDao {
    UserDTO findLoginUser(String username, String password);
}
