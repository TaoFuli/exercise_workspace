package com.tfl.service;

import java.sql.SQLException;
import java.util.List;

import com.tfl.dao.UserDao;
import com.tfl.dao.UserDaoImpl;
import com.tfl.pojo.LeaveWord;
import com.tfl.pojo.Paging;

public class UserServiceImpl implements UserService {
	private final UserDao dao=new UserDaoImpl();
	@Override
	public Paging<LeaveWord> search(int pageSize, int currPage) {
		Paging<LeaveWord> paging=new Paging<>(pageSize,currPage);
		try {
			int rowsCount=dao.selectAllCount();
			int pageCount=(int)Math.ceil(rowsCount/(double)pageSize);
			int begin=(currPage-1)*pageSize;
			List<LeaveWord> data=dao.selectLeaveWordLimit(begin, pageSize);
			//封装到paging
			paging.setRowsCount(rowsCount);
			paging.setPageCount(pageCount);
			paging.setData(data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paging;
	}

}
