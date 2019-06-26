package com.igeek.app;

import redis.clients.jedis.Jedis;

public class TestJRedisDemo {

	public static void main(String[] args) 
	{
		
		System.out.println("helloworld !");
		
		//创建Jedis对象，传递两个参数：第一个host为redis服务器的名称，第二个为redis服务器的端口号 
		Jedis jedis = new Jedis("127.0.0.1", 6379); 
		
		//进行设值操作 
//		jedis.set("username","zhangsan1"); 
		
//		//从redis中取值 
		String username = jedis.get("username"); 
//		
		
		System.out.println("username:"+username);

	}

}
