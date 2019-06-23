package com.tfl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tfl.dao.AccountDao;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public boolean transfer(String outName, String inName, Double money) {
		int n=accountDao.out(outName, money);
		int m=accountDao.in(inName, money);
		if(n<=0||m<0) {
			throw new RuntimeException("转账失败！");
		}
		return n>0&&m>0;
	}

}
