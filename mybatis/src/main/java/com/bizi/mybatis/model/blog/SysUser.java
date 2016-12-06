package com.bizi.mybatis.model.blog;

import java.io.Serializable;

/**
 * Created by guo on 15-3-13.
 */

public class SysUser implements Serializable{
    private String username;
    private String password;
    private String realName;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
