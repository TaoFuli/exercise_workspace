package com.tfl.pojo;

import org.springframework.beans.factory.FactoryBean;

public class PersonFactory3 implements FactoryBean<Person> {

	@Override
	public Person getObject() throws Exception {
		return new Person("王五","我是隔壁的"); 
	}

	@Override
	public Class<?> getObjectType() {
		
		return Person.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
