package com.bizi.study.controller;

import com.bizi.framework.spring.BaseController;
import com.bizi.study.dto.weixin.WeiXinREQ;
import com.bizi.study.dto.weixin.WeiXinResult;
import com.bizi.study.service.IWeiXinservice;
import com.bizi.study.util.CheckWeiXinUtil;
import com.bizi.sdk.tools.BaseAppException;
import com.bizi.study.dto.weixin.WeiXinConst;
import com.bizi.tools.log.LogUtil;
import com.bizi.tools.validate.ValidateUtil;
import com.bizi.tools.xml.XMLUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Date;

/**
 * desc：
 * aithor：guofangbi
 * date:2015/4/15
 */
@Controller
@RequestMapping(value = "/weixin")
public class WeiXinController extends BaseController {

	@Resource
	private IWeiXinservice weiXinservice;

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public void first(String signature, String timestamp, String nonce, String echostr) {

		try {
			if (!CheckWeiXinUtil.checkWeiXin(signature, timestamp, nonce)) {

				echostr = "校验失败";
			}
		} catch (BaseAppException e) {
			echostr = e.getExceptionMsg();
			LogUtil.error(logger,"参数",signature,"参数为空");
		}
		writeResponse(echostr);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/hello")
	public void second() {
		String param = getRequestParam();
		if(ValidateUtil.isBlank(param)){
			LogUtil.error(logger,"param",param,"传来数据为空");
			return;
		}
		WeiXinREQ req = XMLUtil.xmlToBean(WeiXinREQ.class, param);
		WeiXinResult result = null;
		String content = req.getContent();
		switch (req.getMsgType()) {
			case WeiXinConst.MESSAGE_TYPE_TEXT:
				result = weiXinservice.dealText(content, req.getFromUserName());
				break;
			case WeiXinConst.MESSAGE_TYPE_EVENT:
				switch (req.getEvent()) {
					case WeiXinConst.MESSAGE_EVENT_SUBSCRIBE: {
						result = weiXinservice.dealSubscribe();
					}
				}
				break;
		}
		result.setCreateTime(new Date().getTime());
		result.setFromUserName(req.getToUserName());
		result.setToUserName(req.getFromUserName());
		System.out.println(XMLUtil.beanToXML(result));
		writeResponse(XMLUtil.beanToXML(result));


	}

}
