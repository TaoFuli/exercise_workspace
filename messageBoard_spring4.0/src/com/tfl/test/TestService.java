package com.tfl.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tfl.pojo.Message;
import com.tfl.pojo.Paging;
import com.tfl.service.MessageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config.xml")
public class TestService {
	@Autowired
	private  MessageService service;
	
	
	@Test
	public void ttt() {
		Paging<Message> paging = service.search(3, 1);
		System.out.println(paging);
	}

}
