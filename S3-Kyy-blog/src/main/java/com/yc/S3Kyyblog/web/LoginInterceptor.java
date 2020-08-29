package com.yc.S3Kyyblog.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor{
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
		if (request.getSession().getAttribute("loginedUser")==null) {
			String accept = request.getHeader("Accept");
			if (accept.startsWith("application/json")) {
				response.setContentType("application/json,charset=uft-8");
				response.getWriter().append("{\"code\":\"0\",\"msg\":\"请先登录系统\"}");
				
			}else {
				response.setContentType("text/html;charset-uft8");
				response.sendRedirect("/?mustLogin");
			}
			return false;
			
		}
		return true;
	}

}
