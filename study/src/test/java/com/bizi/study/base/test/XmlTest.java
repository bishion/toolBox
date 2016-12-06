package com.bizi.study.base.test;

import com.bizi.study.dto.weixin.Article;
import com.bizi.study.dto.weixin.WeiXinResult;
import com.bizi.study.dto.weixin.WeiXinREQ;
import com.bizi.tools.xml.XMLUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * desc：
 * aithor：guofangbi
 * date:2015/4/16
 */
public class XmlTest {
	private String xml;
	@Before
	public void prepareXML(){
		WeiXinREQ result = new WeiXinREQ();
		result.setFromUserName("user");
		result.setToUserName("user");
		result.setMsgType("text");
		result.setCreateTime(new Date().getTime());
		result.setContent("您发送的消息是：");

		xml = XMLUtil.beanToXML(result);
	}

	@Test
	public void testToXML(){
		WeiXinREQ result = new WeiXinREQ();
		result.setFromUserName("user");
		result.setToUserName("user");
		result.setMsgType("text");
		result.setCreateTime(new Date().getTime());
		result.setContent("您发送的消息是：");

		String xml = XMLUtil.beanToXML(result);
		System.out.println(xml);
	}

	@Test
	public void testToBean(){
		WeiXinREQ bean =  XMLUtil.xmlToBean(WeiXinREQ.class, xml);
		System.out.println(bean.getContent());
	}


	@Test
	public void testWeiXinRsq(){
		WeiXinResult result = new WeiXinResult();
		result.setContent("content");
		result.setCreateTime(new Date().getTime());
		result.setFromUserName("fromUsername");

		List<Article> list = new ArrayList<>();
		Article item1 = new Article();
		item1.setDescription("tetse4t");
		Article item2 = new Article();
		item2.setDescription("tetse4t");
		list.add(item1);
		list.add(item2);

		result.setArticles(list);

		String xml = XMLUtil.beanToXML(result);
		System.out.println(xml);


		WeiXinResult weixin = XMLUtil.xmlToBean(WeiXinResult.class,xml);
		System.out.println(weixin.getArticles().get(0).getDescription());
	}

}
