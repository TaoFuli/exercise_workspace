package com.tfl.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.tfl.pojo.User;
import com.tfl.service.UserService;

/*{"classpath*:spring_dataSource.xml","classpath*:spring_webmvc.xml"}*/
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring_*.xml")
public class TestService {
	@Autowired
	private UserService service;
//	@Test
	public void testLogin() {
		User user=service.login("zhangsan", "123");
		System.out.println(user);
	}
	
	
}
