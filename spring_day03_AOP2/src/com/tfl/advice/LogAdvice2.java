package com.tfl.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvice2 {
	
	/**
	 * 	定义了切入点
	 * @Pointcut  定义在一个私有的方法上，无返回值  参数
	 */
	@Pointcut("execution(* com.tfl.service.*.*(..))")
	private void pc1() {}
	@Pointcut("execution(* com.tfl..*(..))")
	private void pc2() {}
	
	/**
	 * 	前置通知
	 */
	@Before("pc2()")
	public void beforeMethod(JoinPoint jp) {
		String methodName=jp.getSignature().getName();
		System.out.println("[系统日志]  前置通知 ，方法："+methodName);
	}
	/**
	 *	 后置通知
	 * @param jp
	 * @param rs
	 */
	@AfterReturning(value="pc2()",returning="rs")
	public void afterReturnningMethod(JoinPoint jp,Object rs) {
		String methodName=jp.getSignature().getName();
		System.out.println("[系统日志]  后置通知  ，方法："+methodName+",返回值："+rs);
	}
	/**
	 * 最终通知
	 */
	@After("pc2()")
	public void afterMethod(JoinPoint jp) {
		String methodName=jp.getSignature().getName();
		System.out.println("[系统日志]  最终通知，方法："+methodName);
	}
	/**
	 * 	异常通知
	 */
	@AfterThrowing(value="pc1()",throwing="ex")
	public void throwMethod(JoinPoint jp,Throwable ex) {
		String methodName=jp.getSignature().getName();
		System.out.println("[系统日志-异常通知] 异常方法："+methodName+",异常内容："+ex.getMessage());
	}
	
	@Around(value="pc2()")
	public Object aroundMethod(ProceedingJoinPoint pjp)throws Throwable {
		String methodName=pjp.getSignature().getName();
		System.out.println("[系统日志] 环绕通知，方法："+methodName+"开始执行！");
		//执行
		Object rs=null;
		rs=pjp.proceed();
		System.out.println("[系统日志] 环绕通知，方法："+methodName+"执行结束！");
		return rs;
	}
}
