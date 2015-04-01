package com.bestore.ecommerce.web.service;

import java.util.List;

import com.bestore.ecommerce.core.base.BaseService;
import com.bestore.ecommerce.web.model.Role;

/**
 * 角色 业务接口
 * 
 * @author StarZou
 * @since 2014年6月10日 下午4:15:01
 **/
public interface RoleService extends BaseService<Role> {
    /**
     * 通过用户id 查询用户 拥有的角色
     * 
     * @param userId
     * @return
     */
    List<Role> selectRolesByUserId(Long userId);
}
