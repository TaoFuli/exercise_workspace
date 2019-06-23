package com.tfl.advice;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;

public class LogAdvice {
	
	/**
	 * 	前置通知
	 */
	public void beforeMethod(JoinPoint jp) {
		Object[] args=jp.getArgs();//实际参数
//		jp.getThis();//方法
//		jp.getTarget();//目标对象
		String methodName=jp.getSignature().getName();//方法名
		System.out.println("[日志]："+new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date())
				+",方法名："+methodName+",参数："+Arrays.toString(args));
		
		
	}
}
