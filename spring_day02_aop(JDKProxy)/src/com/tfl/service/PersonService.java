package com.tfl.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfl.dao.PersonDao;

@Service("personService")
public class PersonService {
	@Autowired
	private PersonDao personDao;
	public void remover() {
		System.out.println("业务删除");
		personDao.delete();
	}
	@PostConstruct
	public void init() {
		System.out.println("初始化");
	}
	@PreDestroy
	public void des() {
		System.out.println("销毁");
	}
	
}
