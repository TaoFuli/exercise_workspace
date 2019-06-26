package com.igeek.qshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.igeek.qshop.dao.IGoodsDAO;
import com.igeek.qshop.pojo.Category;
import com.igeek.qshop.pojo.Goods;
import com.igeek.utils.JDBCUtils;

public class GoodsDAOImpl implements IGoodsDAO{

	@Override
	public boolean add(Goods goods) throws SQLException 
	{
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into goods values(null,?,?,?,?,?);";
		Object[] params = {goods.getName(),goods.getPrice(),goods.getImage(),goods.getDescription(),goods.getCategory_id()};
		int result = runner.update(sql,params);
		return result>0;
	}

	@Override
	public boolean removeByID(int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modify(Goods goods) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Goods findByID(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from goods;";
		List<Goods> list = runner.query(sql,new BeanListHandler<>(Goods.class));
		return list;
	}

}
