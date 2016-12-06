package com.bizi.blog.controller;

import com.bizi.blog.dto.UserInfo;
import com.bizi.blog.consts.BaseConst;
import com.bizi.blog.service.UserService;
import com.bizi.framework.spring.BaseController;
import com.bizi.tools.exception.BaseAppException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by guo on 15-7-28.
 */
@Controller
@RequestMapping(value = "/user",method = RequestMethod.POST)
public class UserController extends BaseController {

	@Resource
	private UserService userService;
	@RequestMapping("/login.do")
	public String login(String username,String password){
		try {
			UserInfo userInfo = userService.login(username, password);
			super.session.setAttribute(BaseConst.SESSION_USER_INFO,userInfo);
			return "redirect:/write_article.html";
		} catch (BaseAppException e) {
			response.setContentType("text/plain; charset=utf-8");
			this.writeResponse(e.getExceptionMsg());
			return null;
		}

	}
}
