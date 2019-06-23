package com.tfl.dao;

public interface AccountDao {
	public int in(String name,Double money);
	public int out(String name,Double money);
}
