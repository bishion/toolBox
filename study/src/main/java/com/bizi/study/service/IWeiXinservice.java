package com.bizi.study.service;

import com.bizi.study.dto.weixin.WeiXinResult;

/**
 * desc：
 * aithor：guofangbi
 * date:2015/4/16
 */
public interface IWeiXinservice {

	public WeiXinResult dealText(String text,String openId);

	public WeiXinResult dealSubscribe();

}
