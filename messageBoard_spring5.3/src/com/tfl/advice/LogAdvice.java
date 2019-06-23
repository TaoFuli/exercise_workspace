package com.tfl.advice;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tfl.dao.LogDao;


@Component
@Aspect
public class LogAdvice {
	
	private Logger  logger = LogManager.getLogger(LogAdvice.class);
	
	//添加依赖注入
	@Autowired
	private  LogDao  logDao;

	/**
	 * 后置通知  添加操作日志
	 * @param jp
	 * @throws Exception 
	 */
	@AfterReturning(value="execution(* com.igeekhome.service.*.*(..))",returning="rs")
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
