package com.tfl.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tfl.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring_*.xml")
public class TestRunwithContextConfiguration {
	@Autowired
	private PersonService service;
	@Test
	public void testRemove() {
		service.remover();
	}
}
