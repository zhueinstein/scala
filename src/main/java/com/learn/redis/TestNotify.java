package com.learn.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description: 设置过期的key
 * @author: WeFon
 * @date: 2018-10-23 14:25
 * @Copyright: 2018
 */
public class TestNotify {
		public static void main(String[] args) throws InterruptedException {
				JedisPool pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1");
				Jedis jedis = pool.getResource();
				jedis.setex("qrid:19312u31289a", 5,"empty");
		}
}
