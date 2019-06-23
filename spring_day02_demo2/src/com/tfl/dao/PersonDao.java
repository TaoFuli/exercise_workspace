package com.tfl.dao;

import org.springframework.stereotype.Repository;

@Repository("personDao1")
public class PersonDao {
	public int delete() {
		System.out.println("PersonDao 删除成功！");
		return 0;
	}
}
