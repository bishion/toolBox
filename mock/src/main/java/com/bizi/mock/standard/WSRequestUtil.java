package com.bizi.mock.standard;

/**
 * 描述：
 * Created by GuoFangBi on 16-3-10.
 */
public class WSRequestUtil {
    public static String queryResult(String param){
        System.err.println("调用远程接口");
        return "远程返回处理结果";
    }
}
