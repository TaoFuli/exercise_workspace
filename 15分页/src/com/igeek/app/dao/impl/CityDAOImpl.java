package com.igeek.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.igeek.app.dao.ICityDAO;
import com.igeek.app.pojo.City;
import com.igeek.utils.JDBCUtils;

public class CityDAOImpl implements ICityDAO{

	@Override
	public List<City> findCity(int start, int count) throws SQLException 
	{
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from city limit ?,?;";
		Object[] params = {start,count};
		List<City> list = runner.query(sql, new BeanListHandler<>(City.class),params);
		return list;
	}

	@Override
	public long getCityCount() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select count(*) from city;";
		long result = runner.query(sql, new ScalarHandler<>());
		return result;	
	}

	@Override
	public List<City> findCityByCountryCode(String code, int start, int count) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from city where CountryCode=? limit ?,?;";
		Object[] params = {code,start,count};
		List<City> list = runner.query(sql, new BeanListHandler<>(City.class),params);
		return list;
	}

	@Override
	public long getCityCountByCountryCode(String code) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select count(*) from city where CountryCode=?;";
		long result = runner.query(sql, new ScalarHandler<>(),code);
		return result;	
	}
}
