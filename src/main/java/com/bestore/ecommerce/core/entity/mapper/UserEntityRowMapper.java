package com.bestore.ecommerce.core.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bestore.ecommerce.core.entity.db.UserEntity;

public class UserEntityRowMapper implements RowMapper<UserEntity> {

	@Override
	public UserEntity mapRow(ResultSet rs, int index) throws SQLException {
		UserEntityResultSetExtractor extractor = new UserEntityResultSetExtractor();
	    return extractor.extractData(rs);
	}

}
