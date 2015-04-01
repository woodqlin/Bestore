package com.bestore.ecommerce.core.base;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * @author Kevin
 * 
 * @param <T>
 */
public abstract class AbstractBaseDao<T>{

	//Spring JDBC interface
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	@Autowired
	@Qualifier("jdbcTemplate")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/**
	 * @param date
	 * @return Timestamp
	 */
	public Timestamp getTimestamp(Date date) {
		return toTimestamp(date, null);
	}

	/**
	 * @param date
	 * @param format
	 * @return Timestamp
	 */
	public Timestamp getTimestamp(Date date, String format) {
		return toTimestamp(date, format);
	}

	/**
	 * @param date
	 * @param format
	 * @return Timestamp
	 */
	public Timestamp toTimestamp(Date date, String format) {
		if (null == format || "".equals(format))
			format = DEFAULT_FORMAT;
		return Timestamp.valueOf(new SimpleDateFormat(format).format(date));
	}

	/** 
	 * @param timestamp
	 * @return Date
	 */
	public Date getDate(Timestamp timestamp) {
		return toDate(timestamp, null);
	}

	/**
	 * 
	 * @param timestamp
	 * @param format
	 * @return Date
	 */
	public Date getDate(Timestamp timestamp, String format) {
		return toDate(timestamp, format);
	}

	/**
	 * @param timestamp
	 * @param format
	 * @return Date
	 */
	public Date toDate(Timestamp timestamp, String format) {
		Date date = null;
		if (null == format || "".equals(format))
			format = DEFAULT_FORMAT;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			date = sdf.parse(sdf.format(timestamp));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
