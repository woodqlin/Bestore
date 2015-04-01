package com.bestore.ecommerce.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bestore.ecommerce.core.base.BaseDao;
import com.bestore.ecommerce.web.dao.UserDao;
import com.bestore.ecommerce.web.model.User;
import com.bestore.ecommerce.web.service.UserService;

/**
 * 用户Service实现类
 *
 * @author StarZou
 * @since 2014年7月5日 上午11:54:24
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public int insert(User model) {
        return userDao.insert(model);
    }

    public int update(User model) {
        return userDao.update(model);
    }

    public int delete(Long id) {
        return userDao.deleteById(id);
    }

    public User authentication(User user) {
        return userDao.authentication(user);
    }

    public User selectById(Long id) {
        return userDao.queryById(id);
    }


    public BaseDao<User> getDao() {
        return userDao;
    }

    public User selectByUsername(String username) {
    	return userDao.queryByUserName(username).get(0);
    }

}
