package com.bestore.ecommerce.core.base;

import java.io.Serializable;
import java.util.List;

/**
 * DAO base class
 * 
 * @author Kevin
 * @param <T>
 */
public interface BaseDao<T> {

	/**
	 * save object
	 * 
	 * @param model
	 */
	public int insert(T model);

	/**
	 * save for batch
	 * @param models
	 * @return 
	 */
	public int insertForBatch(final List<T> models);

	/**
	 * update object
	 * 
	 * @param model
	 */
	public int update(T model);

	/**
	 * batch update
	 * @param models
	 * @return Integer
	 */
	public int updateForBatch(final List<T> models);

	/**
	 * delete by id
	 * @param id
	 */
	public int deleteById(final Serializable id);

	/**
	 * delete by list of id
	 * 
	 * @param list<id>
	 */
	public int deleteByIdForBatch(final List<Serializable> list);

	/**
	 * query for all
	 * 
	 * @return List<T>
	 */
	public List<T> queryForAll();

	/**
	 * query data by id
	 * 
	 * @param id
	 * @return T
	 */
	public T queryById(final Serializable id);

	/**
	 * query for page total count
	 * 
	 * @return Serializable
	 */
	public Serializable queryForPageTotal();

	/**
	 * query for page
	 * 
	 * @param offset
	 * @param total
	 * @return List<T>
	 */
	public List<T> queryForPageList(final Serializable offset,final Serializable total);

}