package com.tfl.proxy.test;

import org.junit.Test;

import com.tfl.proxy.JDKProxyFactory;
import com.tfl.proxy.service.CustomerService;
import com.tfl.proxy.service.CustomerServiceImpl;

public class TestProxyInstance {
	@Test
	public void testSave2() {
		CustomerServiceImpl target =new CustomerServiceImpl();
		JDKProxyFactory factory=new JDKProxyFactory(target);
		CustomerService service=(CustomerService)factory.getProxyObject();
		service.save();
		service.find();
	}
	@Test
	public void testSave() {
		CustomerService service=new CustomerServiceImpl();
		service.save();
	}
}
