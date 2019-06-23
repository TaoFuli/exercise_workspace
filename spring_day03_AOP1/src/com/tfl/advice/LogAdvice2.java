package com.tfl.advice;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;

public class LogAdvice2 {
	/**
	 * 	前置通知
	 */
	public void beforeMethod2(JoinPoint jp)
	{
		Object[] args=jp.getArgs();
		String methodName=jp.getSignature().getName();
		System.out.println("[2前置通知2]"+new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date())
				+",方法名："+methodName+",参数："+Arrays.toString(args));
	}
}
