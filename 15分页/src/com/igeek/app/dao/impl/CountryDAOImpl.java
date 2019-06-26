package com.igeek.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.igeek.app.dao.ICountryDAO;
import com.igeek.app.pojo.Country;
import com.igeek.utils.JDBCUtils;



public class CountryDAOImpl implements ICountryDAO{

	@Override
	public List<Country> findAll() throws SQLException {
		
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select CODE,Name,Capital from country";
		List<Country> list = runner.query(sql, new BeanListHandler<>(Country.class));
		return list;
	}

	@Override
	public List<Country> findCountry(int start, int count) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select CODE,Name,Capital from country limit ?,?;";
		Object[] params = {start,count};
		List<Country> list = runner.query(sql, new BeanListHandler<>(Country.class),params);
		return list;	
	}

	@Override
	public long getCountryCount() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select count(*) from country;";
		long result = runner.query(sql, new ScalarHandler<>());
		return result;	
	}

}
