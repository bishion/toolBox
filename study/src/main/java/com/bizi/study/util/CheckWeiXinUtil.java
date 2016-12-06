package com.bizi.study.util;

import com.bizi.sdk.base.ExceptionConst;
import com.bizi.study.base.BaseConst;
import com.bizi.tools.secret.EncryptUtil;
import com.bizi.sdk.tools.BaseAppException;
import com.bizi.tools.validate.ValidateUtil;

import java.util.Arrays;

/**
 * desc：
 * aithor：guofangbi
 * date:2015/4/15
 */
public class CheckWeiXinUtil {

	public static boolean checkWeiXin(String signature,String timestamp,String nonce) throws BaseAppException {
		if(ValidateUtil.hasOneNullOrEmpty(signature,timestamp,nonce)){
			throw new BaseAppException(ExceptionConst.USER_PARAM_HAS_NULL);
		}
		String[] arr = {BaseConst.TOKEN,timestamp,nonce};
		// 排序
		Arrays.sort(arr);

		//拼接
		StringBuffer content = new StringBuffer();
		for (int i = 0; i< arr.length;i++){
			content.append(arr[i]);
		}

		String temp = EncryptUtil.SHAEnc(content.toString());

		return temp.equals(signature);
	}
}
