package com.tfl.dao;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.tfl.pojo.LeaveWord;

public class DaoTest {
	@Test
	public void test() throws SQLException {
		UserDao u=new UserDaoImpl();
//		System.out.println(u.insertByLeaveWord(new LeaveWord("你好发的","zhangsan")));
		List<LeaveWord> l=u.selectByleaveWord(0, 1);
		Iterator<LeaveWord> it = l.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
		for (LeaveWord le : l) {
			System.out.println(le.toString());
		}
	}
}
