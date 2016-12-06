package com.bizi.blog.filter;

import com.bizi.blog.consts.BaseConst;
import com.bizi.tools.validate.ValidateUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by guo on 15-7-28.
 */
public class SessionFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)servletRequest).getSession();
		if(ValidateUtil.isNull(session.getAttribute(BaseConst.SESSION_USER_INFO))){
			return ;
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {

	}
}
