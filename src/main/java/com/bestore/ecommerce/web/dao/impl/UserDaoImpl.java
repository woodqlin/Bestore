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
import com.bestore.ecommerce.web.dao.UserDao;
import com.bestore.ecommerce.web.model.User;


/**
 * 
 * @author Kevin
 *
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractBaseDao<User> implements UserDao {

	
	public int checkUser(String username) {
		String sql = "select count(1) from t_user where username = ?";
		return this.getJdbcTemplate().queryForObject(sql,
				new Object[] { username }, Integer.class);
	}

	public List<User> queryByUserName(String username) {
		String sql = "select t1.* from t_user t1 where t1.username = ?";
		return this.getJdbcTemplate().query(sql, new Object[] { username },
				new UserMapper());
	}

	public List<User> queryForAll() {
		String sql = "select * from t_user";
		return this.getJdbcTemplate().query(sql, new UserMapper());
	}

	public int insert(User user) {
		String sql = "insert into t_user(USERNAME,PASSWORD,NAME,DESCRIPTION,EMAIL,STATUS,LOGIN_COUNT,LAST_DATE,LAST_IP,CREATE_DATE) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return this.getJdbcTemplate().update(
				sql,
				new Object[] { user.getUsername(), user.getPassword(),
						user.getName(), user.getDescription(), user.getEmail(),
						user.getStatus(), user.getLoginCount(), user.getLastDate(),
						user.getLastIP(), user.getCreateDate() });
	}

	public int deleteById(Serializable id) {
		String sql = "delete from t_user where id = ?";
		return this.getJdbcTemplate().update(sql, new Object[] { id });
	}

	public int deleteByIdForBatch(final List<Serializable> list) {

		if (null == list || list.isEmpty())
			return 0;

		final int size = list.size();

		String sql = "delete from t_user where id = ?";
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

	public int insertForBatch(final List<User> models) {

		if (null == models || models.isEmpty())
			return 0;

		final int size = models.size();

		String sql = "insert into t_user(USERNAME,PASSWORD,NAME,DESCRIPTION,EMAIL,STATUS,LOGIN_COUNT,LAST_DATE,LAST_IP,CREATE_DATE) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {

			public int getBatchSize() {
				return size;
			}

			public void setValues(PreparedStatement ps, int i)
					throws SQLException {
				User user = models.get(i);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				ps.setString(3, "test");
				ps.setString(4, user.getDescription());
				ps.setString(5, user.getEmail());
				ps.setString(6, user.getStatus());
				ps.setInt(7, user.getLoginCount());
				ps.setTimestamp(8, getTimestamp(user.getLastDate()));
				ps.setString(9, user.getLastIP());
				ps.setTimestamp(10, getTimestamp(user.getCreateDate()));
			}

		};
		this.getJdbcTemplate().batchUpdate(sql, setter);
		return size;
	}

	public User queryById(Serializable id) {
		String sql = "select * from t_user where id = ?";
		List<User> list = this.getJdbcTemplate().query(sql,
				new Object[] { id }, new UserMapper());
		if (null == list || list.isEmpty())
			return null;
		return list.get(0);
	}

	public List<User> queryForPageList(Serializable offset, Serializable total) {
		String sql = "select * from t_user limit ?, ?";
		return this.getJdbcTemplate().query(sql,
				new Object[] { offset, total }, new UserMapper());
	}

	public Serializable queryForPageTotal() {
		String sql = "select count(1) from t_user";
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	public int update(User model) {
		String sql = "update t_user set PASSWORD=?, NAME=?, DESCRIPTION=?, EMAIL=?, STATUS=?, LOGIN_COUNT=?, LAST_DATE=?, LAST_IP=? where id = ?";
		return this.getJdbcTemplate()
				.update(
						sql,
						new Object[] { model.getPassword(), model.getName(), 
								model.getDescription(), model.getEmail(), model.getStatus(),
								model.getLoginCount(), model.getLastDate(), model.getLastIP(),
								model.getId() });
	}
	

	public User authentication(User user) {
		String sql = "select * from t_user t1 where t1.username = ? and t1.password = ?";
		List<User> list = this.getJdbcTemplate().query(sql, new Object[] { user.getUsername(), user.getPassword() },
				new UserMapper());
		if (null == list || list.isEmpty())
			return null;
		return list.get(0);
	}

	public int updateForBatch(final List<User> models) {

		if (null == models || models.isEmpty())
			return 0;

		final int size = models.size();

		String sql = "update t_user set PASSWORD=?, NAME=?, DESCRIPTION=?, EMAIL=?, STATUS=?, LOGIN_COUNT=?, LAST_DATE=?, LAST_IP=? where id = ?";
		BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {

			public int getBatchSize() {
				return size;
			}

			public void setValues(PreparedStatement ps, int i)
					throws SQLException {
				User user = models.get(i);
				ps.setString(1, user.getPassword());
				ps.setString(2, user.getName());
				ps.setString(3, user.getDescription());
				ps.setString(4, user.getEmail());
				ps.setString(5, user.getStatus());
				ps.setInt(6, user.getLoginCount());
				ps.setTimestamp(7, getTimestamp(user.getLastDate()));
				ps.setString(8, user.getLastIP());
				ps.setLong(9, user.getId());

			}
		};
		this.getJdbcTemplate().batchUpdate(sql, setter);
		return size;
	}

	private class UserMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int i) throws SQLException {
			User vo = new User();
			vo.setId(rs.getLong("ID"));
			vo.setUsername(rs.getString("USERNAME"));
			vo.setPassword(rs.getString("PASSWORD"));
			vo.setName(rs.getString("NAME"));
			vo.setDescription(rs.getString("DESCRIPTION"));
			vo.setEmail(rs.getString("EMAIL"));
			vo.setLastIP(rs.getString("LAST_IP"));
			vo.setLoginCount(rs.getInt("LOGIN_COUNT"));
			vo.setLastDate(getDate(rs.getTimestamp("LAST_DATE")));
			vo.setCreateDate(getDate(rs.getTimestamp("CREATE_DATE")));
			vo.setStatus(rs.getString("STATUS"));
			return vo;
		}
	}

}
