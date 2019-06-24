package com.tfl.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.tfl.pojo.LeaveWord;
import com.tfl.utils.C3P0Utils;

public class UserDaoImpl implements UserDao {
	private final QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
	@Override
	public int selectAllCount() throws SQLException {
		String sql="select count(1) from leaveword";
		long count=qr.query(sql, new ScalarHandler<Long>());
		return (int)count;
	}

	@Override
	public List<LeaveWord> selectLeaveWordLimit(int begin, int size) throws SQLException {
		String sql="select * from leaveword limit ?,?";
		Object[] params= {begin,size};
		return qr.query(sql, new BeanListHandler<LeaveWord>(LeaveWord.class),params);
	}

}
