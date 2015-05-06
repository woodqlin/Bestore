package com.bestore.ecommerce.core.mocksession;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Modify it if use distributed system
 */
public class SessionManager {
	private static final Logger logger = LoggerFactory.getLogger(SessionManager.class);
	private Map<String, UserContext> usersContext = new HashMap<String, UserContext>();
	
	public Date getTimestamp(String uid){
		UserContext user = usersContext.get(uid);
		if (user == null){
			logger.error("cannot find timestamp in session manager : "+uid);
			return null;
		}
		return user.getTimestamp();
	}
	
	public UserContext getUserContext(String uid){
		return usersContext.get(uid);
	}
}
