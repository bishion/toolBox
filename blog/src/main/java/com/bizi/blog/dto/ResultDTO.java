package com.bizi.blog.dto;

import com.bizi.blog.consts.BaseConst;

/**
 * Created by guo on 15-7-22.
 */
public class ResultDTO {
	private boolean resultCode = BaseConst.NO;
	private String resultMsg;

	public ResultDTO() {
	}

	public ResultDTO(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public ResultDTO(boolean resultCode, String resultMsg) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}

	public boolean isResultCode() {
		return resultCode;
	}

	public void setResultCode(boolean resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
}
