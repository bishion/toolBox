package com.bizi.blog.utils;

import com.bizi.blog.consts.HtmlConst;
import com.bizi.blog.dto.ArticleDTO;
import com.bizi.tools.date.DateUtil;

import java.util.Date;

/**
 * Created by guo on 15-7-22.
 */
public class ArticleUtil {
	public static String getArticle(ArticleDTO article){
		StringBuffer sb = new StringBuffer();

		sb.append(HtmlConst.TEMPLATE_CATEGORY);
		sb.append(article.getCategory());

		sb.append(HtmlConst.TEMPLATE_AUTHOR);
		sb.append(article.getAuthor());

		sb.append(HtmlConst.TEMPLATE_CREATE_DATE);
		sb.append(DateUtil.toString(new Date(), DateUtil.yyyy_MM_dd_HH_mm));

		sb.append(HtmlConst.TEMPLATE_TITLE);
		sb.append(article.getTitle());

		sb.append(HtmlConst.TEMPLATE_CONTENT);
		sb.append(article.getContent());

		sb.append(HtmlConst.TEMPLATE_END);
		return sb.toString();
	}
}
