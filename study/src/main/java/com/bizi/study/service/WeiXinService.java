package com.bizi.study.service;

import com.bizi.study.dto.weixin.Article;
import com.bizi.study.dto.weixin.WeiXinResult;
import com.bizi.study.model.market.SysUser;
import com.bizi.tools.exception.BaseAppException;
import com.bizi.tools.validate.ValidateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * desc：
 * aithor：guofangbi
 * date:2015/4/16
 */
@Service
public class WeiXinService implements IWeiXinservice {

	@Resource
	private UserService userService;

	@Override
	public WeiXinResult dealText(String text, String openId) {
		String[] message = text.split("#");
		WeiXinResult result = new WeiXinResult();
		switch (message[0]) {
			case "help":{
				result.setContent("感谢您关注Bishion的公众账号.请按提示进行操作:\n" +
						"1:注册:101#姓名#密码:比如:101#Bishion#123456;\n" +
						"2:输入'202'查询个人信息;\n" +
						"3:输入'303'接收一条图文消息;");
			}
			break;
			case "101":
				try {
					SysUser user = new SysUser();
					user.setOpenId(openId);
					user.setUsername(message[1]);
					user.setPassword(message[2]);
					userService.register(user);
					result.setContent("注册成功");
				} catch (BaseAppException e) {
					result.setContent("您已经注册过，请输入'202'查询");
				}
				break;
			case "202":
				SysUser user = userService.getSysUser(openId);
				if(ValidateUtil.isNull(user) || ValidateUtil.hasOneNullOrEmpty(user.getUsername(),user.getPassword())){
					result.setContent("您还没有注册，请输入'help'按提示操作");
				}else {
					result.setContent("您的姓名为：" + user.getUsername() + ";密码为：" + user.getPassword());
				}
				break;
			case "303":
				Article article = new Article();
				article.setDescription("郭芳碧的描述");
				article.setPicUrl("http://mmbiz.qpic.cn/mmbiz/WRGz2LWLARDd4DFTYadp33t4CGv2G84TEvbGIPs8Z1QpashwIkbibNN679I24qSnK5wQdwETQiaQSniabZdzg3sdw/640?tp=webp&wxfrom=5");
				article.setTitle("郭芳碧说：阿里汽车接入4S店，6月份才能在线下直接购买Apple Watch");
				article.setUrl("http://www.baidu.com");

				Article article1 = new Article();
				article1.setDescription("郭芳碧的描述");
				article1.setPicUrl("http://mmbiz.qpic.cn/mmbiz/WRGz2LWLARDd4DFTYadp33t4CGv2G84T0uApcllO680JZPQTz9eqkTyaia2CKrd4DOZvylZsqgClw7XgvHddpiag/640?tp=webp&wxfrom=5");
				article1.setTitle("这是一条测试数据");
				article1.setUrl("http://www.baidu.com");

				Article article2 = new Article();
				article2.setDescription("郭芳碧的描述");
				article2.setPicUrl("http://mmbiz.qpic.cn/mmbiz/WRGz2LWLARDd4DFTYadp33t4CGv2G84T0uApcllO680JZPQTz9eqkTyaia2CKrd4DOZvylZsqgClw7XgvHddpiag/640?tp=webp&wxfrom=5");
				article2.setTitle("郭芳碧说：阿里汽车接入4S店，6月份才能在线下直接购买Apple Watch");
				article2.setUrl("http://www.baidu.com");

				Article article3 = new Article();
				article3.setDescription("郭芳碧的描述");
				article3.setPicUrl("http://mmbiz.qpic.cn/mmbiz/WRGz2LWLARDd4DFTYadp33t4CGv2G84T0uApcllO680JZPQTz9eqkTyaia2CKrd4DOZvylZsqgClw7XgvHddpiag/640?tp=webp&wxfrom=5");
				article3.setTitle("这是一条测试数据");
				article3.setUrl("http://www.baidu.com");

				List<Article> articleList = new ArrayList<>();
				articleList.add(article);
				articleList.add(article1);
				articleList.add(article2);
				articleList.add(article3);

				result.setArticles(articleList);
				result.setMsgType("news");
				result.setArticleCount(4);

				break;
			default:
				result.setContent("不知所云,请输入'help'查看提示");

		}
		return result;
	}

	@Override
	public WeiXinResult dealSubscribe() {
		WeiXinResult result = new WeiXinResult();
		result.setContent("感谢您关注Bishion的公众账号.请按提示进行操作:\n" +
				"1:注册:101#姓名#密码:比如:101#Bishion#123456;\n" +
				"2:输入'202'查询个人信息;\n" +
				"3:输入'303'接收一条图文消息;");
		return result;
	}
}
