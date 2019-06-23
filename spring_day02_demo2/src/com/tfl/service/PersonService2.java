package com.tfl.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.tfl.dao.PersonDa;

@Service("personService")
@Scope(scopeName="singleton")//指定作用域为单例
public class PersonService2 {
	
	/**
	 * 自动装配
	 *  @Autowired  按照类型查找   如果一个接口有多个实现类  必须要使用 @Qualifier 指定具体的实现类
	 *  @Resource JSR-250标准中指定的 ，首先按照 名称查找，如果找不到，再按照类型查找
	 */
	
	/*@Autowired
	@Qualifier("personDao2")*/
	
	
//	@Resource(name="personDao2")//指明单个实例对象
	@Resource(name="personDao")
	private PersonDa personDa;
	
	public void setPersonDa(PersonDa personDa) {
		this.personDa=personDa;
	}
	public void remove() {
		System.out.println("业务移除");
		personDa.delete();
	}
	/**
	 * 	初始化的时候执行。相当于<bean id="service" 
	 * class="...PersonService" init-method="init" destory-method="des">
	 * </bean>
	 */
	@PostConstruct
	public void init() {
		System.out.println("初始化");
	}
	/**
	 * 	销毁时在单例模式才有效
	 */
	@PreDestroy
	public void des() {
		System.out.println("销毁");
	}
}
