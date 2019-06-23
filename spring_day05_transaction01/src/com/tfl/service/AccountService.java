package com.tfl.service;

public interface AccountService {
	/**
	 * 转账操作的业务逻辑
	 */
	public boolean transfer(String outName,String inName,Double money);
}
