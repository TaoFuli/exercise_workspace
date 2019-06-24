package com.tfl;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTest {
	
	@Test
	public void jedisPool() {
		//创建JedisPool连接池配置
		JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
		//设置连接池的最大连接数
		jedisPoolConfig.setMaxTotal(20);
		//设置连接池的最大连接空闲数
		jedisPoolConfig.setMaxIdle(2);
		
		//实例化连接池
		JedisPool pool=new JedisPool(jedisPoolConfig,"192.168.3.189",6379);
		Jedis jd=pool.getResource();//获取一个连接
		
		jd.auth("123456");
		jd.select(0);//设置使用的那个数据库表
		/*jd.flushAll();//清空所有的库表
		jd.flushDB();//清空当前表库    
         */	
		
		String r=jd.ping();
		System.out.println(r);
		
		System.out.println(jd.get("name"));
		
		//集合的操作
		jd.lpush("lisi", "lisi,123456");
		System.out.println(jd.lpop("lisi"));
		
		jd.select(1);
		System.out.println(jd.ping());
		jd.lpush("lisi", "12345601111");
		System.out.println(jd.lpop("lisi"));
		jd.flushDB();
		System.out.println(jd.lpop("lisi"));
		jd.asking
		
		pool.close();
		}
}
