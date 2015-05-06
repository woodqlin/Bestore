package com.bestore.ecommerce.core.validate;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.bestore.ecommerce.core.mocksession.SessionManager;
import com.bestore.ecommerce.core.mocksession.UserContext;
import com.bestore.ecommerce.web.interceptors.HMACInterceptor;

public class HeadValidator {
	private SessionManager sessManager;
	
	public void setSessManager(SessionManager sessManager) {
		this.sessManager = sessManager;
	}
	
	public SessionManager getSessManager() {
		return sessManager;
	}
	
	public boolean evaluate(String encryptionType, Date timestamp, String token){
		if (encryptionType.equals(HMACInterceptor.HMAC_TOKEN)){
			String[] split = token.split(":");
			
			if (split.length != 3)
				return false;
			
			UserContext userContext = sessManager.getUserContext(split[0]);
			if (userContext == null)
				return false;
			
			if (userContext.getNonce().equals(split[1])){
				return false;
			}
			return true;
		}
		return false;
	}
}
