package com.bizi.study.controller;

import com.bizi.framework.spring.BaseController;
import com.bizi.sdk.response.BaseResult;
import com.bizi.study.model.market.SysUser;
import com.bizi.study.service.UserService;
import com.bizi.tools.exception.BaseAppException;
import com.bizi.tools.json.JsonMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by guo on 15-4-3.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/login")
    public void login() {
        BaseResult loginResponse = new BaseResult();

        try {
            SysUser loginRequest = JsonMapper.fromJson(getRequestParam(), SysUser.class);
            List<SysUser> sysUserList = userService.login(loginRequest.getUsername(), loginRequest.getPassword());

            loginResponse.setResultCode("1");
            loginResponse.setResultMsg(JsonMapper.toNormalJson(sysUserList));

        } catch (BaseAppException e) {
            e.printStackTrace();
            loginResponse.setResultMsg(e.getExceptionMsg());
        } catch (Exception e) {
            e.printStackTrace();
            loginResponse.setResultMsg("未知异常，请重试");
        }

        writeResponse(JsonMapper.toNormalJson(loginResponse));
    }

    @RequestMapping(value = "/register")
    public void register(){
        BaseResult loginResponse = new BaseResult();
        try{
            SysUser sysUser = JsonMapper.fromJson(getRequestParam(), SysUser.class);
            userService.register(sysUser);
            loginResponse.setResultCode("1");
            loginResponse.setResultMsg("注册成功");
        }catch (BaseAppException e){
            loginResponse.setResultMsg(e.getExceptionMsg());
        }catch (Exception e){
            e.printStackTrace();
            loginResponse.setResultMsg("未知异常，请重试");
        }
        writeResponse(JsonMapper.toNormalJson(loginResponse));
    }

}