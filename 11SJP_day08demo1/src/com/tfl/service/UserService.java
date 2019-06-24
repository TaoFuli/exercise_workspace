package com.tfl.service;

import java.util.List;

import com.tfl.pojo.LeaveWord;
import com.tfl.pojo.Paging;
import com.tfl.pojo.User;

public interface UserService {
	//登录查询
	User selectByloginNameAndPassword(String loginName,String password);
	//注册用户信息
	boolean insertByUser(User user);
	//登录名模糊查询所有用户信息
	List<User> selectByloginName(String queryString);
	//修改用户信息
	boolean editUser(User user);
	//注销用户信息
	boolean removeUser(User user);
	
	
	//添加留言信息
	boolean insertByLeaveWord(LeaveWord leaveword);
	//查询该用户的所有留言
	List<LeaveWord> selectByloginName(User user);
	//查询所有的留言信息
	Paging<LeaveWord> selectByleaveWord(int begin, int size);
	//修改留言内容
	boolean editLeaveWord(LeaveWord leaveword);
	//删除留言
	boolean removeLeaveWord(LeaveWord leaveword);
	//通过wid查询留言
	LeaveWord selectByWid(int wid);
}
