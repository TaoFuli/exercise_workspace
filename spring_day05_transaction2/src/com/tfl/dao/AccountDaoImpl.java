package com.tfl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private JdbcTemplate template;
	/**
	 * 转入
	 */
	@Override
	public int in(String name, Double money) {
		String sql="UPDATE account SET money=money+? WHERE accountName=?";
		Object[] args= {money,name};
		
		return template.update(sql, args);
	}

	/**
	 * 转出
	 */
	@Override
	public int out(String name, Double money) {
		String sql="UPDATE account SET money=money-? WHERE accountName=?";
		Object[] args= {money,name};
		
		return template.update(sql, args);
	}

}
