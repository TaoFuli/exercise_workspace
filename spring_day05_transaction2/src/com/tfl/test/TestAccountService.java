package com.tfl.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tfl.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-tx.xml")
public class TestAccountService {
	@Autowired
	private AccountService service;
	
	@Test
	public void test1() {
		boolean b=service.transfer("wangwu", "lisi", 100D);
		Assert.assertTrue(b);
	}
	/**
	 * 测试转账
	 */
	@Test
	public void test2() {
		boolean b=service.transfer("lisi", "zhangsan", 200D);
		Assert.assertTrue(b);
	}
}
