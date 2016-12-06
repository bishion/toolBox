package com.bizi.sdk.service;

import com.bizi.sdk.base.ConfigConst;
import com.bizi.sdk.base.ExceptionConst;
import com.bizi.sdk.request.UserInfo;
import com.bizi.sdk.response.BaseResult;
import com.bizi.sdk.tools.HttpMethods;
import com.bizi.sdk.tools.BaseAppException;
import com.bizi.sdk.tools.JavaClient;
import com.bizi.sdk.tools.ValidateUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;

/**
 * Created by guo on 15-4-3.
 */
public class UserClient extends JavaClient {
    /**
     * 客户端构造函数
     */
    public UserClient() {
        this.schema = ConfigConst.HTTP_SCHEMA;
        this.ip = ConfigConst.HTTP_IP;
        this.port = ConfigConst.HTTP_PORT;
        this.contextPath = ConfigConst.HTTP_CONTEXT;
    }

    /**
     * 请求注册信息
     * @param userInfo 用户信息
     * @return 返回结果信息
     */
    public BaseResult register(UserInfo userInfo) throws BaseAppException {
        if(ValidateUtils.isNull(userInfo) || ValidateUtils.hasOneEmpty(userInfo.getUsername(),userInfo.getPassword())){
            throw new BaseAppException(ExceptionConst.USER_PARAM_HAS_NULL);
        }

        HttpClient client = createHttpClient();
        HttpPost post = HttpMethods.post(createURI(ConfigConst.POST_REGISTER));
        String json = mapper.toJson(userInfo);
        post.setEntity(createStringEntity(json));

        String resultJson = executeHttpRequest(client,post);
        return super.fromJson(resultJson,BaseResult.class);
    }
    /**
     * 请求登录信息
     * userInfo 登录信息
     * @return BaseResult
     */

    public BaseResult login(UserInfo userInfo){
        HttpClient client = createHttpClient();
        HttpPost post = HttpMethods.post(createURI(ConfigConst.POST_LOGIN));
        String json = mapper.toJson(userInfo);
        post.setEntity(createStringEntity(json));

        String resultJson = executeHttpRequest(client, post);
        return super.fromJson(resultJson,BaseResult.class);
    }
}
