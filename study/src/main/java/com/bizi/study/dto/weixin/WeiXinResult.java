package com.bizi.study.dto.weixin;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * desc
 * aithor guofangbi
 * date:2015/4/15
 */
@XStreamAlias("xml")
public class WeiXinResult {
	@XStreamAlias("ToUserName")
	private String toUserName;
	@XStreamAlias("FromUserName")
	private String fromUserName;
	@XStreamAlias("CreateTime")
	private Long createTime;
	@XStreamAlias("MsgType")
	private String msgType;
	@XStreamAlias("Content")
	private String content;
	@XStreamAlias("ArticleCount")
	private int articleCount;
	@XStreamAlias("Articles")
	private List<Article> articles;

	public WeiXinResult() {
		this.msgType = WeiXinConst.MESSAGE_TYPE_TEXT;
	}


	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
