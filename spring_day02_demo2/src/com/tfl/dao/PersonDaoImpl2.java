package com.tfl.dao;

import org.springframework.stereotype.Repository;

@Repository("personDao2")
public class PersonDaoImpl2 implements PersonDa {
	public int delete() {
		System.out.println("PersonDaoImpl2删除");
		return 0;
	}
}
