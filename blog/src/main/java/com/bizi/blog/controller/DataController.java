package com.bizi.blog.controller;

import com.bizi.blog.dto.ResultDTO;
import com.bizi.blog.consts.BaseConst;
import com.bizi.blog.service.DataService;
import com.bizi.framework.spring.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by guo on 15-7-26.
 */
@Controller
@RequestMapping(value = "/data")
public class DataController extends BaseController {
	@Resource
	private DataService dataService;

	@RequestMapping(value = "/asyncData.do")
	public void asyncData(){
		try{
			dataService.asyncData();
		}catch (Exception e){
			this.writeObjResponse(new ResultDTO(e.getMessage()));
			return ;
		}
		this.writeObjResponse(new ResultDTO(BaseConst.YES, "同步成功"));
	}
}
