package com.bestore.ecommerce.web.dao;

import java.io.Serializable;
import java.util.List;

import com.bestore.ecommerce.core.base.BaseDao;
import com.bestore.ecommerce.web.model.Role;

/**
 * role interface
 * 
 * @author Kevin
 * 
 */
public interface RoleDao extends BaseDao<Role> {

	public List<Role> queryByResourceId(Serializable id);

	public List<Role> queryByUserId(Serializable id);

	/**
	 * query role by isAllot
	 * 
	 * @param id
	 * @param isAllot
	 * @return List<Role>
	 */
	public List<Role> queryAllotRole(Serializable id, boolean isAllot);

	/**
	 * save user-role map 
	 * 
	 * @param userId
	 * @param roleId
	 * @return int (the number of rows affected)
	 */
	public int insertRelation(Serializable userId, Serializable roleId);

	/**
	 * delete user-role map 
	 * 
	 * @param userId
	 * @param roleId
	 * @return int (the number of rows affected)
	 */
	public int deleteRelation(Serializable userId, Serializable roleId);
}