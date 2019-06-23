package com.tfl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class LogDaoImpl implements LogDao {
	
	private JdbcTemplate template ;
	
	//spring注入
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

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
