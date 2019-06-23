package com.tfl.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tfl.dao.PersonDao;

@Service("personService1")
public class PersonService {
	private PersonDao personDao;

	@Value("#{personDao1}")
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
	public void remove() {
		System.out.println("业务层service删除用户");
		personDao.delete();
	}
}
