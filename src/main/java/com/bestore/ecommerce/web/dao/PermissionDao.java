package com.bestore.ecommerce.web.dao;

import java.io.Serializable;
import java.util.List;

import com.bestore.ecommerce.core.base.BaseDao;
import com.bestore.ecommerce.web.model.Permission;

/**
 * resource interface
 * 
 * @author Kevin
 * 
 */
public interface PermissionDao extends BaseDao<Permission> {

	/**
	 * query role by isAllot
	 * 
	 * @param id
	 * @param isAllot
	 * @return List<Resource>
	 */
	public List<Permission> queryAllotResource(Serializable id, boolean isAllot);

	/**
	 * save role-resource map
	 * 
	 * @param roleId
	 * @param resourceId
	 * @return int (the number of rows affected)
	 */
	public int insertRelation(Serializable roleId, Serializable resourceId);

	/**
	 * delete role-resource map
	 * 
	 * @param roleId
	 * @param resourceId
	 * @return int (the number of rows affected)
	 */
	public int deleteRelation(Serializable roleId, Serializable resourceId);
}