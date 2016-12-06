package com.bizi.tools.exception;

public class BaseAppException extends Exception {
	private static final long serialVersionUID = 1L;
	// 异常代码
	private String exceptionCode;
	// 异常信息
	private String exceptionMsg;

	public BaseAppException() {
	}

	public BaseAppException(Throwable cause) {
		super(cause);
	}


	public BaseAppException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseAppException(String exceptionCode, String exceptionMsg) {
		this.exceptionCode = exceptionCode;
		this.exceptionMsg = exceptionMsg;
	}

	public BaseAppException(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

}
