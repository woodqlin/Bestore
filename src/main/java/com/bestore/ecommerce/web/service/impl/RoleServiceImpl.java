package com.bestore.ecommerce.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bestore.ecommerce.core.base.BaseDao;
import com.bestore.ecommerce.web.dao.RoleDao;
import com.bestore.ecommerce.web.model.Role;
import com.bestore.ecommerce.web.service.RoleService;

/**
 * 角色Service实现类
 *
 * @author StarZou
 * @since 2014年6月10日 下午4:16:33
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    public BaseDao<Role> getDao() {
        return roleDao;
    }
    
    public List<Role> selectRolesByUserId(Long userId) {
        return roleDao.queryAllotRole(userId, true);
    }

}
