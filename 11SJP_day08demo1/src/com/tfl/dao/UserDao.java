package com.tfl.dao;

import java.sql.SQLException;
import java.util.List;

import com.tfl.pojo.LeaveWord;
import com.tfl.pojo.User;

public interface UserDao {
	//登录查询
	User selectByloginNameAndPassword(String loginName,String password) throws SQLException;
	//注册用户信息
	int insertByUser(User user) throws SQLException;
	//登录名模糊查询所有用户信息
	List<User> selectByloginName(String queryString) throws SQLException;
	//修改用户信息
	int editUser(User user) throws SQLException;
	//注销用户信息
	int removeUser(User user) throws SQLException;
	
	
	//添加留言信息
	int insertByLeaveWord(LeaveWord leaveword) throws SQLException;
	//查询该用户的所有留言
	List<LeaveWord> selectByloginName(User user) throws SQLException;
	//查询所有的留言信息
	List<LeaveWord> selectByleaveWord(int begin, int size) throws SQLException;
	//修改留言内容
	int editLeaveWord(LeaveWord leaveword) throws SQLException;
	//删除留言
	int removeLeaveWord(LeaveWord leaveword) throws SQLException;
	//查询留言总记录数
	int selectLeaveWordCount() throws SQLException;
	//通过wid查询留言
	LeaveWord selectByWid(int wid) throws SQLException;
}
