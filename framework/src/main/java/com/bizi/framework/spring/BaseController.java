package com.bizi.framework.spring;

import com.bizi.tools.json.JsonMapper;
import com.bizi.tools.log.LogUtil;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by guo on 15-3-19.
 */
public class BaseController {
    protected HttpServletResponse response;
    protected HttpServletRequest request;
    protected HttpSession session;

    protected transient final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @ModelAttribute
    protected void initReqAndRes(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.session = request.getSession();

    }

    protected void writeResponse(String message){
        try{

            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/plain; charset=utf-8");
            response.getWriter().write(message);
            response.getWriter().flush();
        }catch (Exception e){
            LogUtil.error(logger,"要传送的message",message,e);
        }
    }
    protected void writeObjResponse(Object object){
        this.writeResponse(JsonMapper.toNonNullJson(object));
    }
    protected String getRequestParam(){
        try {
            return IOUtils.toString(request.getInputStream(), "UTF-8");
        } catch (Exception e) {
            LogUtil.error(logger, "获取请求参数失败", "getRequestParam", e);
        }
        return null;
    }

}
