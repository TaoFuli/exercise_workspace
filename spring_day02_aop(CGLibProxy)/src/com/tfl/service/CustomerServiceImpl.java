package com.tfl.service;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public void save() {
		System.out.println("业务---保存数据");
	}

	@Override
	public int find() {
		System.out.println("业务---查询数据");
		return 0;
	}

}
