package com.tfl.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Date;

public class JDKProxyFactory {
	private Object target;

	public JDKProxyFactory(Object target) {
		this.target = target;
	}
	
	/**
	 * 	返回代理后的对象
	 */
	public Object getProxyObject() {
		Object proxyObject=Proxy.newProxyInstance(JDKProxyFactory.class.getClassLoader()
				, target.getClass().getInterfaces(), new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// TODO Auto-generated method stub
						System.out.println("[系统操作日志]"+new Date()
								+",执行了"+method.getName()+"方法.参数为："+Arrays.toString(args));
						return method.invoke(target, args);
					}
				});
		return proxyObject;
	}
}
