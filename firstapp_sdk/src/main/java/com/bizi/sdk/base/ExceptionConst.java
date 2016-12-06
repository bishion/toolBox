package com.bizi.sdk.base;

/**
 * Created by guo on 15-4-2.
 */
public enum  ExceptionConst {
    USER_PARAM_HAS_NULL("USR0001", "用户名或密码为空"),
    CHEK_PARAM_HAS_NULL("CHK0001", "传来数据不能为空");


    private String code;
    private String message;

    ExceptionConst(String code,String message){
        this.code = code;
        this.message = message;
    }


    public String getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }

}
