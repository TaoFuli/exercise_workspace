package com.tfl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LogDaoImpl implements LogDao {
	
	@Autowired
	private JdbcTemplate template ;
	

	@Override
	public int insert(String context) throws Exception {
		String sql = "INSERT INTO log_table(context)  VALUES(?)";
		return template.update(sql,context);
	}

	@Override
	public List<Map<String, Object>> selectAll() throws Exception {
		return template.queryForList("SELECT * FROM  log_table ORDER BY id DESC");
	}

}
