package com.bestore.ecommerce.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bestore.ecommerce.core.base.BaseDao;
import com.bestore.ecommerce.web.dao.PermissionDao;
import com.bestore.ecommerce.web.model.Permission;
import com.bestore.ecommerce.web.service.PermissionService;

/**
 * 权限Service实现类
 *
 * @author StarZou
 * @since 2014年6月10日 下午12:05:03
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionDao permissionDao;

    public BaseDao<Permission> getDao() {
        return permissionDao;
    }

    public List<Permission> selectPermissionsByRoleId(Long roleId) {
        return permissionDao.queryAllotResource(roleId, true);
    }
}
