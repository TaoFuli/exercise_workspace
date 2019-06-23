package com.tfl.service;

import java.util.List;

import com.tfl.dao.MessageDao;
import com.tfl.dao.MessageDaoImpl;
import com.tfl.dao.UserDao;
import com.tfl.dao.UserDaoImpl;
import com.tfl.pojo.Message;
import com.tfl.pojo.Paging;
import com.tfl.pojo.User;

public class MessageServiceImpl implements MessageService {
	
	//依赖Dao
	private UserDao userDao;
	private MessageDao msgDao;
	
	//spring注入
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setMsgDao(MessageDao msgDao) {
		this.msgDao = msgDao;
	}


	public MessageServiceImpl() {
	/*	userDao = new UserDaoImpl();
		msgDao = new MessageDaoImpl();*/
	}
	

	/**
	 * 登录
	 */
	@Override
	public User login(String name, String pwd) {
		try {
			return userDao.selectByLoginNameAndPassword(name, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 注册
	 */
	@Override
	public boolean register(User user) {
		try {
			return userDao.insertUser(user)>0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 发布
	 */
	@Override
	public boolean publishMessage(Message msg) {
		try {
			return msgDao.insertMessage(msg)>0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改
	 */
	@Override
	public boolean editMessage(Message msg) {
		try {
			return msgDao.updateMessage(msg)>0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 删除
	 */
	@Override
	public boolean deleteMessageById(int id) {
		try {
			return msgDao.deleteMessage(id)>0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 分页查询
	 */
	@Override
	public Paging<Message> search(int pageSize, int currPage) {
		Paging<Message> paging = new Paging<>(pageSize, currPage);
		
		try {
			//取得总记录数
			int rowsCount  = msgDao.selectMessageCount();
			int pageCount = (int)Math.ceil(rowsCount/(double)pageSize);
			int begin = (currPage-1)*pageSize;
			List<Message> list = msgDao.selectAllMessages(begin,pageSize);
			
			//封装
			paging.setRowsCount(rowsCount);
			paging.setPageCount(pageCount);
			paging.setData(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return paging;
	}


	/**
	 * 按照id查找 用户
	 */
	@Override
	public User searchUserById(int id) {
		try {
			return userDao.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 按照id查找 留言
	 */
	@Override
	public Message searchMessageById(int id) {
		try {
			return msgDao.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
