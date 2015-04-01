package com.bestore.ecommerce.web.dao;

import java.util.List;

import com.bestore.ecommerce.core.base.BaseDao;
import com.bestore.ecommerce.web.model.User;


public interface UserDao extends BaseDao<User>{

	public List<User> queryByUserName(String username);

	public int checkUser(String username);
	
	public User authentication(User user);

}