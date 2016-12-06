package com.bizi.sdk.response;

import com.bizi.sdk.base.BaseConst;

/**
 * 通用的返回数据格式
 * resultCode：返回码：1执行表示成功，0表示执行失败
 * resultMsg：返回结果信息：如果成功，则为返回数据，如果失败，则为失败原因
 * Created by guo on 15-4-3.
 */
public class BaseResult {
    private String resultCode = BaseConst.NO;
    private String resultMsg;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
