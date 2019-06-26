package com.igeek.app.listener;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person implements HttpSessionActivationListener,Serializable
{
	private int id;
	private String name;
	
	
	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("person 被活化");
	}
	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("person 被钝化");
	}

}
