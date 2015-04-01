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
import com.bestore.ecommerce.web.dao.RoleDao;
import com.bestore.ecommerce.web.model.Role;


/**
 * 
 * @author Kevin
 * 
 */
@Repository("roleDao")
public class RoleDaoImpl extends AbstractBaseDao<Role> implements RoleDao {

	public List<Role> queryByResourceId(Serializable id) {
		String sql = "select t1.* from t_role t1, t_role_resource_map t2, t_resource t3 where t3.id = t2.resc_id and t1.id = t2.role_id and t3.id = ?";
		List<Role> list = this.getJdbcTemplate().query(sql,
				new Object[] { id }, new RoleMapper());
		return list;
	}

	public List<Role> queryBySign(Role role) {
		return null;
	}

	public List<Role> queryByUserId(Serializable id) {
		String sql = "select t2.* from t_user t1, t_role t2, t_user_role_map t3 where t1.id = t3.user_id and t2.id = t3.role_id and t1.id = ?";
		List<Role> list = this.getJdbcTemplate().query(sql,
				new Object[] { id }, new RoleMapper());
		return list;
	}

	public int deleteById(Serializable id) {
		String sql = "delete from t_role where id = ?";
		return this.getJdbcTemplate().update(sql, new Object[] { id });
	}

	public int deleteByIdForBatch(final List<Serializable> list) {

		if (null == list || list.isEmpty())
			return 0;

		final int size = list.size();

		String sql = "delete from t_role where id = ?";

		BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {

			public int getBatchSize() {
				return size;
			}

			public void setValues(PreparedStatement ps, int i)
					throws SQLException {
				Serializable id = list.get(i);
				ps.setLong(1, Long.valueOf(id.toString()));
			}
		};

		this.getJdbcTemplate().batchUpdate(sql, setter);

		return size;
	}

	public int deleteByModel(Role model) {
		String sql = "delete from t_role where id = ?";
		return this.getJdbcTemplate().update(sql,
				new Object[] { model.getId() });
	}

	public int insert(Role model) {
		String sql = "insert into t_role(ROLE_NAME, DESCRIPTION, ENABLED, CREATE_DATE) values(?, ?, ?, ?)";
		return this.getJdbcTemplate().update(
				sql,
				new Object[] { model.getRoleName(), model.getDescription(),
						model.isEnabled(), model.getCreateDate() });
	}

	public int insertForBatch(final List<Role> models) {

		if (null == models || models.isEmpty())
			return 0;

		final int size = models.size();

		String sql = "insert into t_role(ROLE_NAME, DESCRIPTION, ENABLED, CREATE_DATE) values(?, ?, ?, ?)";
		BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {

			public int getBatchSize() {
				return size;
			}

			public void setValues(PreparedStatement ps, int i)
					throws SQLException {
				Role role = models.get(i);
				ps.setString(1, role.getRoleName());
				ps.setString(2, role.getDescription());
				ps.setBoolean(3, role.isEnabled());
				ps.setTimestamp(4, getTimestamp(role.getCreateDate()));
			}

		};
		this.getJdbcTemplate().batchUpdate(sql, setter);
		return size;
	}

	public Role queryById(Serializable id) {
		String sql = "select * from t_role where id = ?";
		List<Role> roles = this.getJdbcTemplate().query(sql,
				new Object[] { id }, new RoleMapper());
		if (null == roles || roles.isEmpty())
			return null;
		return roles.get(0);
	}

	public List<Role> queryForAll() {
		String sql = "select * from t_role";
		return this.getJdbcTemplate().query(sql, new RoleMapper());
	}

	public List<Role> queryForPageList(Serializable offset, Serializable total) {
		String sql = "select * from t_role limit ?, ?";
		return this.getJdbcTemplate().query(sql,
				new Object[] { offset, total }, new RoleMapper());
	}

	public Serializable queryForPageTotal() {
		String sql = "select count(1) from t_user where username = ?";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	public int update(Role model) {
		String sql = "update t_role set ROLE_NAME = ?, DESCRIPTION = ?, ENABLED = ? where ID = ?";
		return this.getJdbcTemplate().update(
				sql,
				new Object[] { model.getRoleName(), model.getDescription(),
						model.isEnabled(), model.getId() });
	}

	public int updateForBatch(final List<Role> models) {

		if (null == models || models.isEmpty())
			return 0;

		final int size = models.size();

		String sql = "update t_role set ROLE_NAME = ?, DESCRIPTION = ?, ENABLED = ? where ID = ?";

		BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {
			public int getBatchSize() {
				return size;
			}

			public void setValues(PreparedStatement ps, int i)
					throws SQLException {
				Role role = models.get(i);
				ps.setString(1, role.getRoleName());
				ps.setString(2, role.getDescription());
				ps.setBoolean(3, role.isEnabled());
				ps.setLong(4, role.getId());
			}

		};
		this.getJdbcTemplate().batchUpdate(sql, setter);
		return size;
	}

	private class RoleMapper implements RowMapper<Role> {
		public Role mapRow(ResultSet rs, int i) throws SQLException {
			Role vo = new Role();
			vo.setId(rs.getLong("ID"));
			vo.setRoleName(rs.getString("ROLE_NAME"));
			vo.setDescription(rs.getString("DESCRIPTION"));
			vo.setEnabled(rs.getBoolean("ENABLED"));
			vo.setCreateDate(getDate(rs.getTimestamp("CREATE_DATE")));
			return vo;
		}
	}

	public List<Role> queryAllotRole(Serializable id, boolean isAllot) {
		String sql = null;
		if (isAllot) {
			sql = "select * from t_role where id in (select role_id from t_user_role_map where user_id = ?)";
		} else {
			sql = "select * from t_role where id not in (select role_id from t_user_role_map where user_id = ?)";
		}
		return this.getJdbcTemplate().query(sql, new Object[] { id },
				new RoleMapper());
	}

	public int deleteRelation(Serializable userId, Serializable roleId) {
		String sql = "delete from t_user_role_map where user_id = ? and role_id = ?";
		return this.getJdbcTemplate().update(sql,
				new Object[] { userId, roleId });
	}

	public int insertRelation(Serializable userId, Serializable roleId) {
		String sql = "insert into t_user_role_map(user_id, role_id) values(?, ?)";
		return this.getJdbcTemplate().update(sql,
				new Object[] { userId, roleId });
	}
}
