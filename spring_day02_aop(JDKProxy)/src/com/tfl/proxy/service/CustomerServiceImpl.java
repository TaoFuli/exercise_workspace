package com.tfl.proxy.service;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public void save() {
		System.out.println("业务层--保存数据");

	}

	@Override
	public int find() {
		System.out.println("业务层---查找数据");
		return 0;
	}

}
