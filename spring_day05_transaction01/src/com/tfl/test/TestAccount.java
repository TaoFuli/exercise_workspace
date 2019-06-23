package com.tfl.test;


import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tfl.service.AccountService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring_config.xml")
public class TestAccount {
	@Autowired
	private AccountService service;
	@Test
	public void test() {
		boolean b=service.transfer("zhangsan", "lisi",1000D);
		//断言 比较实际结果和预期的结果
		Assert.assertTrue(b);
	}
	
	//如果方法中 声明或抛出了   检查异常，调用的时候必须处理
	@Test
	public void test2() {
		try {
			throw new IOException("sss");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//如果方法中 声明或抛出了  非检查异常，调用的时候可以不处理
	@Test
	public void test3() {
		throw new RuntimeException("sss");
	}
}
