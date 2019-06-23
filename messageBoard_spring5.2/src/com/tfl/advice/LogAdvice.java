package com.tfl.advice;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.aspectj.lang.JoinPoint;

import com.tfl.dao.LogDao;

public class LogAdvice {
	
	private Logger  logger = LogManager.getLogger(LogAdvice.class);
	
	//添加依赖注入
	private  LogDao  logDao;
	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}

	/**
	 * 后置通知  添加操作日志
	 * @param jp
	 * @throws Exception 
	 */
	public  void  afterRunningMethod(JoinPoint jp,Object rs) throws Exception {
		String methodName = jp.getSignature().getName(); //方法名称
		Object[] args = jp.getArgs();
		String  msg = "执行方法:"+methodName+"("+Arrays.toString(args)+"),返回值:"+rs;
		
		//插入日志
		logDao.insert(msg);
		
		//log4j
		logger.info(msg);
	}
	
}
