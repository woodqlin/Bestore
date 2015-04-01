package com.bestore.ecommerce.web.dao.impl;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bestore.ecommerce.core.base.AbstractBaseDao;
import com.bestore.ecommerce.web.dao.PermissionDao;
import com.bestore.ecommerce.web.model.Permission;

/**
 * 
 * @author Kevin
 * 
 */
@Repository("permissionDao")
public class PermissionDaoImpl extends AbstractBaseDao<Permission> implements
		PermissionDao {

	private class ResourceMapper implements RowMapper<Permission> {
		public Permission mapRow(ResultSet rs, int i) throws SQLException {
			Permission vo = new Permission();
			vo.setId(rs.getLong("ID"));
			vo.setRescName(rs.getString("RESC_NAME"));
			vo.setRescType(rs.getString("RESC_TYPE"));
			vo.setContent(rs.getString("CONTENT"));
			vo.setEnabled(rs.getBoolean("ENABLED"));
			vo.setCreateDate(getDate(rs.getTimestamp("CREATE_DATE")));
			return vo;
		}
	}

	public int deleteById(Serializable id) {
		String sql = "delete from t_resource where id = ?";
		return this.getJdbcTemplate().update(sql, new Object[] { id });
	}

	public int deleteByIdForBatch(final List<Serializable> list) {

		if (null == list || list.isEmpty())
			return 0;

		final int size = list.size();

		String sql = "delete from t_resource where id = ?";
		BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {

			public int getBatchSize() {
				return size;
			}

			public void setValues(PreparedStatement ps, int i)
					throws SQLException {
				Serializable id = list.get(i);
				ps.setInt(1, Integer.valueOf(id.toString()));
			}

		};
		this.getJdbcTemplate().batchUpdate(sql, setter);
		return size;
	}

	public int insert(Permission model) {
		String sql = "insert into t_resource(RESC_NAME,RESC_TYPE,CONTENT,ENABLED,CREATE_DATE) values(?, ?, ?, ?, ?)";
		return this.getJdbcTemplate().update(
				sql,
				new Object[] { model.getRescName(), model.getRescType(),
						model.getContent(), model.isEnabled(),
						model.getCreateDate() });
	}

	public int insertForBatch(final List<Permission> models) {

		if (null == models || models.isEmpty())
			return 0;

		final int size = models.size();

		String sql = "insert into t_resource(RESC_NAME,RESC_TYPE,CONTENT,ENABLED,CREATE_DATE) values(?, ?, ?, ?, ?)";
		BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {

			public int getBatchSize() {
				return size;
			}

			public void setValues(PreparedStatement ps, int i)
					throws SQLException {
				Permission resource = models.get(i);
				ps.setString(1, resource.getRescName());
				ps.setString(2, resource.getRescType());
				ps.setString(3, resource.getContent());
				ps.setBoolean(4, resource.isEnabled());
				ps.setTimestamp(5, getTimestamp(resource.getCreateDate()));
			}

		};
		this.getJdbcTemplate().batchUpdate(sql, setter);
		return size;
	}

	public Permission queryById(Serializable id) {
		String sql = "select * from t_resource where id = ?";
		List<Permission> list = this.getJdbcTemplate().query(sql,
				new Object[] { id }, new ResourceMapper());
		if (null == list || list.isEmpty())
			return null;
		return list.get(0);
	}

	public List<Permission> queryForAll() {
		String sql = "select * from t_resource";
		return this.getJdbcTemplate().query(sql, new ResourceMapper());
	}

	public List<Permission> queryForPageList(Serializable offset,
			Serializable total) {
		String sql = "select * from t_resource limit ?, ?";
		return this.getJdbcTemplate().query(sql,
				new Object[] { offset, total }, new ResourceMapper());
	}

	public Serializable queryForPageTotal() {
		String sql = "select count(1) from t_resource";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	public int update(Permission model) {
		String sql = "update t_resource set RESC_NAME=?, RESC_TYPE=?, CONTENT=?, ENABLED=? where id = ?";
		return this.getJdbcTemplate().update(
				sql,
				new Object[] { model.getRescName(), model.getRescType(),
						model.getContent(), model.isEnabled(), model.getId() });
	}

	public int updateForBatch(final List<Permission> models) {

		if (null == models || models.isEmpty())
			return 0;

		final int size = models.size();

		String sql = "update t_resource set RESC_NAME=?, RESC_TYPE=?, CONTENT=?, ENABLED=? where id = ?";
		BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {

			public int getBatchSize() {
				return size;
			}

			public void setValues(PreparedStatement ps, int i)
					throws SQLException {
				Permission resource = models.get(i);
				ps.setString(1, resource.getRescName());
				ps.setString(2, resource.getRescType());
				ps.setString(3, resource.getContent());
				ps.setBoolean(4, resource.isEnabled());
				ps.setLong(5, resource.getId());
			}

		};
		this.getJdbcTemplate().batchUpdate(sql, setter);
		return size;
	}

	public List<Permission> queryAllotResource(Serializable id, boolean isAllot) {
		String sql = null;
		if (isAllot) {
			sql = "select * from t_resource where id in (select resc_id from t_role_resource_map where role_id = ?)";
		} else {
			sql = "select * from t_resource where id not in (select resc_id from t_role_resource_map where role_id = ?)";
		}
		return this.getJdbcTemplate().query(sql, new Object[] { id },
				new ResourceMapper());
	}

	public int deleteRelation(Serializable roleId, Serializable resourceId) {
		String sql = "delete from t_role_resource_map where role_id = ? and resc_id = ?";
		return this.getJdbcTemplate().update(sql,
				new Object[] { roleId, resourceId });
	}

	public int insertRelation(Serializable roleId, Serializable resourceId) {
		String sql = "insert into t_role_resource(role_id, resc_id) values(?, ?)";
		return this.getJdbcTemplate().update(sql,
				new Object[] { roleId, resourceId });
	}

}
