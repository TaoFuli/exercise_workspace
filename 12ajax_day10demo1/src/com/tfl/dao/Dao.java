package com.tfl.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tfl.pojo.LeaveWord;
import com.tfl.utils.C3P0Utils;

public class Dao {
private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	
	public List<LeaveWord> select(String str){
		try {
			return qr.query("SELECT * FROM  leaveword WHERE fk_uloginName LIKE ?"
					, new BeanListHandler<LeaveWord>(LeaveWord.class),"%"+str+"%");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
