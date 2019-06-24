package com.tfl.dao;

import java.sql.SQLException;
import java.util.List;

import com.tfl.pojo.LeaveWord;

public interface UserDao {
	int selectAllCount() throws SQLException;
	List<LeaveWord> selectLeaveWordLimit(int begin,int size) throws SQLException;
}
