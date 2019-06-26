package com.tfl.dao;

import org.springframework.stereotype.Repository;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {

	@Override
	public int delete() {
		System.out.println("PersonDaoImpl删除");
		return 0;
	}

}