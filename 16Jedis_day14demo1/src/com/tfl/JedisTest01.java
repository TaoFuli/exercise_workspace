package com.tfl;


import org.junit.Test;

import redis.clients.jedis.Jedis;

public class JedisTest01 {

	@Test
	public  void ping1() throws Exception{
		@SuppressWarnings("resource")
		Jedis jd1=new Jedis("192.168.3.189",6379);
		jd1.auth("123456");//输入的密码
		String r=jd1.ping();
		System.out.println(r);
		System.out.println(jd1.get("user"));
	}
}
