package com.igeek.app;

import redis.clients.jedis.Jedis;

public class TestJRedisDemo3 {

	public static void main(String[] args) 
	{
		
		System.out.println("helloworld !");
		
		//创建Jedis对象，传递两个参数：第一个host为redis服务器的名称，第二个为redis服务器的端口号 
		Jedis jedis = new Jedis("106.15.138.25", 6379); 
		
		jedis.auth("abc123");
		
		//进行设值操作 
		for(int i=0;i<10001;i++)
		{
			System.out.println(i);
			jedis.set(""+i,""+i);
		}
		
//		//从redis中取值 
//		String username = jedis.get("username"); 
//		
		
//		System.out.println("username:"+username);

	}

}
