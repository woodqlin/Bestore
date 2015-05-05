package com.bestore.ecommerce.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HMACInterceptor extends HandlerInterceptorAdapter {
	public final static String HMAC_HEADER = "Authentication";
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String auth_header = request.getHeader(HMAC_HEADER);
		
		String[] auth_header_split = auth_header.trim().split(" ");
		//Only support HMAC here
		return true;
	}
	
}
