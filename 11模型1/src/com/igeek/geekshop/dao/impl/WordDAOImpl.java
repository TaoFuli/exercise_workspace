package com.igeek.geekshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.igeek.geekshop.dao.IWordDAO;
import com.igeek.geekshop.domain.User;
import com.igeek.geekshop.domain.Word;
import com.igeek.utils.JDBCUtils;

public class WordDAOImpl implements IWordDAO
{

	@Override
	public boolean add(String word,int user_id) throws SQLException 
	{
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into word values (null,?,?)";
		Object[] params = {word,user_id};
		int result = runner.update(sql,params);
		return result>0;
	}

	@Override
	public boolean removeByID(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "delete from word where id = ?;";
		Object[] params = {id};
		int result = runner.update(sql,params);
		return result>0;
	}

	@Override
	public boolean removeByWord(String word) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "delete from word where word = ?;";
		Object[] params = {word};
		int result = runner.update(sql,params);
		return result>0;
	}

	@Override
	public boolean modify(Word word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Word findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Word findByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Word> findAll(int user_id) throws SQLException 
	{
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from word where user_id = ?;";
		Object[] params = {user_id};
		List<Word> list= runner.query(sql,new BeanListHandler<>(Word.class),params);
		return list;
	}

}
