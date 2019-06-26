package com.igeek.app.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer implements HttpSessionBindingListener
{
	private int id;
	private String name;
	
	
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("Customer对象被绑定到Session中了");
		
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Customer对象取消绑定到Session中了");
	}
	
	

}
