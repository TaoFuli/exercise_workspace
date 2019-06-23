package com.tfl.advice;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;

public class LogAdvice {
	/**
	 * 前置通知：在方法执行之前触发执行
	 * @param jp
	 */
	public void beforeMethod(JoinPoint jp) {
		Object[] args=jp.getArgs();
		jp.getTarget();//获取目标对象
		String name=jp.getSignature().getName();
		System.out.println("[系统日志1]"+new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date())+"方法："+name+"参数："+Arrays.toString(args));
		
	}
	/**
	 * 	后置通知：在方法执行即将返回之前 自动触发执行
	 * @param jp
	 * @param rs
	 */
	public void afterReturnningMethod(JoinPoint jp,Object rs) {
		Object[] args=jp.getArgs();
		jp.getTarget();
		String name=jp.getSignature().getName();
		System.out.println("[系统日志2]"+new SimpleDateFormat().format(new Date())+"方法："+name+"参数："+Arrays.toString(args)+"返回值："+rs);
	}
}
