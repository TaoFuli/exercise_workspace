package com.tfl.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tfl.pojo.Item;
import com.tfl.service.ItemService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring_webmvc.xml")
public class TestService {
	
	@Autowired
	private ItemService service;
	
	@Test
	public void test1() {
		List<Item> list=service.findAll();
		for(Item item:list) {
			System.out.println(item);
		}
	}

}
