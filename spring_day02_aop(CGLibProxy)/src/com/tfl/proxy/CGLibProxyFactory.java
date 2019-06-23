package com.tfl.proxy;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CGLibProxyFactory implements MethodInterceptor{
	private Object target;
	//注入 target 目标对象
	public CGLibProxyFactory(Object target) {
		this.target=target;
	}
	/**
	 * 返回代理后的对象
	 */
	public Object getProxyObject() {
		//1.代理对象生成器（工厂思想）
		Enhancer enhancer=new Enhancer();
		//类加载器
		enhancer.setClassLoader(target.getClass().getClassLoader());
		//2.在增强器上设置两个属性
		//设置要生成代理对象的目标对象：生成的目标对象类型的子类型
		enhancer.setSuperclass(target.getClass());
		//设置回调方法
		enhancer.setCallback(this);
		//Callback
		//3.创建获取对象
		return enhancer.create();
	}
	@Override
	public Object intercept(Object targetObj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("[系统操作日志]"+new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date())
				+"\n执行了方法："+method.getName()+",参数为："+Arrays.toString(args));
		return method.invoke(target, args);
	}
}
