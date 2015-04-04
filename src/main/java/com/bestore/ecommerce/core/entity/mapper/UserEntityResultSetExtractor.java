package com.bestore.ecommerce.core.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bestore.ecommerce.core.entity.db.UserEntity;

public class UserEntityResultSetExtractor implements ResultSetExtractor<UserEntity> {

	@Override
	public UserEntity extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		
		
		return null;
	}

}
