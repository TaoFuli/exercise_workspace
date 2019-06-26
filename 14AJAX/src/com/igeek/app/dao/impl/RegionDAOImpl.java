package com.igeek.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.igeek.app.dao.IRegionDAO;
import com.igeek.app.pojo.Region;
import com.igeek.utils.JDBCUtils;

public class RegionDAOImpl implements IRegionDAO{

	@Override
	public List<Region> findAllByParentId(int parent_id) throws SQLException 
	{
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from region where parent_id = ?;";
		List<Region> result = runner.query(sql, new BeanListHandler<>(Region.class),parent_id);
		return result;
	}

	@Override
	public Region findCityByName(String name) throws SQLException 
	{
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
//		String sql = "select * from region where name = ?;";
//		String sql = "select * from region where name like %?%;";
		String sql = "select * from region where name like '%"+name+"%';";
		Region result = runner.query(sql, new BeanHandler<>(Region.class));
		return result;
	}

	@Override
	public Region findById(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from region where id = ?;";
		Region result = runner.query(sql, new BeanHandler<>(Region.class),id);
		return result;
	}

	@Override
	public List<Region> findAllByName(String name) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from region where name like '%"+name+"%' limit 5;";
		List<Region> result = runner.query(sql, new BeanListHandler<>(Region.class));
		return result;
	}

}
