package com.tfl.service;

import java.sql.SQLException;
import java.util.List;

import com.tfl.dao.UserDao;
import com.tfl.dao.UserDaoImpl;
import com.tfl.pojo.LeaveWord;
import com.tfl.pojo.Paging;
import com.tfl.pojo.User;

public class UserServiceImpl implements UserService {
	private UserDao userDao=new UserDaoImpl();
	/**
	 * 处理登录结果
	 */
	@Override
	public User selectByloginNameAndPassword(String loginName, String password) {
		try {
			return userDao.selectByloginNameAndPassword(loginName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 处理注册结果
	 */
	@Override
	public boolean insertByUser(User user) {
		try {
			if(userDao.insertByUser(user)>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 处理模糊查询，返回结果集
	 */
	@Override
	public List<User> selectByloginName(String queryString) {
		try {
			return userDao.selectByloginName(queryString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 处理修改用户信息
	 */
	@Override
	public boolean editUser(User user) {
		try {
			if(userDao.editUser(user)>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 处理删除用户
	 */
	@Override
	public boolean removeUser(User user) {
		try {
			if(userDao.removeUser(user)>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 添加留言的结果
	 */
	@Override
	public boolean insertByLeaveWord(LeaveWord leaveword) {
		try {
			if(userDao.insertByLeaveWord(leaveword)>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 查询该用户的所有留言信息
	 */
	@Override
	public List<LeaveWord> selectByloginName(User user) {
		try {
			return userDao.selectByloginName(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询所有的留言
	 */
	@Override
	public Paging<LeaveWord> selectByleaveWord(int pageSize,int currPage) {
		Paging<LeaveWord> paging=new Paging<>(pageSize,currPage);
		try {
			//取得总记录数
			int rowsCount=userDao.selectLeaveWordCount();
			int pageCount=(int)Math.ceil(rowsCount/(double)pageSize);
			int begin=(currPage-1)*pageSize;
			List<LeaveWord> list=userDao.selectByleaveWord(begin,pageSize);
			paging.setRowsCount(rowsCount);
			paging.setPageCount(pageCount);
			paging.setData(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paging;
	}

	/**
	 * 修改留言内容
	 */
	@Override
	public boolean editLeaveWord(LeaveWord leaveword) {
		try {
			if(userDao.editLeaveWord(leaveword)>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 删除留言
	 */
	@Override
	public boolean removeLeaveWord(LeaveWord leaveword) {
		try {
			if(userDao.removeLeaveWord(leaveword)>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public LeaveWord selectByWid(int wid) {
		try {
			return userDao.selectByWid(wid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
