package com.tfl.advice;

import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAdvice {
	
	/**
	 * 	前置通知
	 * @param jp
	 */
	public void beforeMethod(JoinPoint jp) {
		Object[] args=jp.getArgs();//实际参数
		String methodName=jp.getSignature().getName();
		System.out.println("[前置通知]"+new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss").format(new Date())
				+",方法名："+methodName+",参数为："+Arrays.toString(args));
		//抛出异常
		/*if("search".equals(methodName)) {
			throw new RuntimeException("search出现异常了");
		}*/
	}
	/**
	 * 	后置通知
	 */
	public void afterReturnningMethod(JoinPoint jp,Object returnValue)
	{
		String methodName=jp.getSignature().getName();//方法名
		System.out.println("[后置通知]"+new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss").format(new Date())
				+",方法名："+methodName+",参数为："+returnValue);
	}
	/**
	 * 	最终通知
	 */
	public void afterMethod(JoinPoint jp) 
	{
		String methodName=jp.getSignature().getName();
		System.out.println("[最终通知]"+new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date())
				+",方法名："+methodName);
	}
	/**
	 * 	异常通知
	 */
	public void throwExceptionMethod(JoinPoint jp,Exception ex)
	{
		String methodName=jp.getSignature().getName();
		System.out.println("[异常通知]"+":方法名"+methodName+",出现异常了："+ex.getMessage());
	}
	/**
	 * 	环绕通知
	 */
	public Object aroundMethod(ProceedingJoinPoint pjp) {
		String methodName=pjp.getSignature().getName();
		Object returnValue=null;
		
		System.out.println("[环绕通知]  开始执行，方法名："+methodName);
		
		//执行方法
		try {
			returnValue=pjp.proceed();
			if("search".equals(methodName)) {
				returnValue=666;
			}else if("remove".equals(methodName))
			{
				returnValue=true;
			}else {
				returnValue=pjp.proceed();
			}
			System.out.println("[环绕通知]  执行完成，方法名："+methodName);
			return returnValue;
		} catch (Throwable e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
