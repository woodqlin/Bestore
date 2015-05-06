package com.bestore.ecommerce.web.interceptors;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bestore.ecommerce.core.validate.HeadValidator;
import com.bestore.ecommerce.web.controller.anno.RequireLogin;

public class HMACInterceptor extends HandlerInterceptorAdapter {
	public final static String HMAC_HEADER = "Authentication";
	public final static String TIMESTAMP_HEADER = "Date";
	
	public final static String HMAC_TOKEN = "hmac";
	
	private static final Logger logger = LoggerFactory.getLogger(HMACInterceptor.class); 
	private String redirectURL;
	
	public String getRedirectURL() {
		return redirectURL;
	}

	public void setRedirectURL(String redirectURL) {
		this.redirectURL = redirectURL;
	}

	private HeadValidator hmacValidator;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod){
			String auth_date = request.getHeader(TIMESTAMP_HEADER);
			if (StringUtils.isBlank(auth_date)){
				logger.error("cannot find date in http header");
				return false;
			}

			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			RequireLogin anno = method.getAnnotation(RequireLogin.class);
			
			if (anno != null){
				//Only support HMAC here
				String auth_header = request.getHeader(HMAC_HEADER);
				if (StringUtils.isBlank(auth_header)){
					return false;
				}
				String[] auth_header_split = auth_header.trim().split(" ");
				if (auth_header_split.length == 0){
					return false;
				}
				
				if (auth_header_split[0].equals(HMAC_TOKEN)){
//					boolean evaluate = hmacValidator.evaluate(HMAC_TOKEN, auth_date, auth_header_split[1]);
//					return evaluate;
					return true;
				}else {
					logger.error("Unsupported encryption method, please contact engineer");
					return false;
				}
				return true;
			}else{
				return true;
			}
		}else{
			return super.preHandle(request, response, handler);
		}
	}
	
}
