package com.bizi.blog.controller;

import com.bizi.blog.dto.ArticleDTO;
import com.bizi.blog.dto.ResultDTO;
import com.bizi.blog.service.ArticleService;
import com.bizi.blog.consts.BaseConst;
import com.bizi.framework.spring.BaseController;
import com.bizi.tools.json.JsonMapper;
import com.bizi.tools.validate.ValidateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by guo on 15-7-22.
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController extends BaseController {
	@Resource
	private ArticleService articleService;

	private ResultDTO resultDTO = new ResultDTO();

	@RequestMapping(value = "/write.do")
	public void writeArticle(String articleString){
		if(ValidateUtil.isNull(session.getAttribute(BaseConst.SESSION_USER_INFO))){
			resultDTO.setResultMsg("用户未登录");
			this.writeObjResponse(resultDTO);
			return ;
		}
		if(ValidateUtil.isBlank(articleString)){
			resultDTO.setResultMsg("参数错误");
			this.writeObjResponse(resultDTO);
			return ;
		}
		ArticleDTO articleDTO = JsonMapper.fromJson(articleString,ArticleDTO.class);
		articleService.insertArticle(articleDTO);
		resultDTO.setResultCode(BaseConst.YES);
		resultDTO.setResultMsg("上传成功");
		this.writeObjResponse(resultDTO);
	}

}
