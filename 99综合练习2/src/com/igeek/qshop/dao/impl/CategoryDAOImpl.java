package com.igeek.qshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.igeek.qshop.dao.ICategoryDAO;
import com.igeek.qshop.pojo.Admin;
import com.igeek.qshop.pojo.Category;
import com.igeek.utils.JDBCUtils;

public class CategoryDAOImpl implements ICategoryDAO{

	@Override
	public boolean add(String name) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into category values(null,?);";
		Object[] params = {name};
		int result = runner.update(sql,params);
		return result>0;
	}

	@Override
	public boolean removeByID(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modify(int id, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from category;";
		List<Category> list = runner.query(sql,new BeanListHandler<>(Category.class));
		return list;
	}

}
