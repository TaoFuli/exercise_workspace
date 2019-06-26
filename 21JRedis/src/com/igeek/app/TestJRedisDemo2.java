package com.igeek.app;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestJRedisDemo2 {

	public static void main(String[] args) 
	{
		
		//创建JedisPool连接池配置 
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig(); 
		//设置连接池的最大连接数 
		jedisPoolConfig.setMaxTotal(20); 
		//设置连接池的最大连接空闲数 
		jedisPoolConfig.setMaxIdle(2); 
		//设置redis服务器的主机 
		String host = "127.0.0.1";
		//设置redis服务器的端口 
		int port = 6379; 
		
		//创建JedisPool连接池对象 
		JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port); 
		
		//获取Jedis对象 
		Jedis jedis = jedisPool.getResource();
		
		// 如果有设置密码
		//jedis.auth("abc123");
		
		System.out.println("debug step:1");
		jedis.select(1);
		System.out.println("debug step:2");
		//存入数据 
		jedis.set("info", "message"); 
		System.out.println("debug step:3");
		//获取数据 
		String info = jedis.get("info");
		System.out.println(info);
		System.out.println("debug step:4");
	}

}
