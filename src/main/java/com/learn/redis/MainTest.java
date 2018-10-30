package com.learn.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

/**
 * @Description:Redis链接测试
 * @author: WeFon
 * @date: 2018-10-23 14:20
 * @Copyright: 2018
 */
public class MainTest {

		public static void main(String[] args) {
				JedisPool pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1");

				Jedis jedis = pool.getResource();
				config(jedis);//建议在redis配置文件中设置

				jedis.psubscribe(new MyJedisPubSub(), "__keyevent@0__:expired");//过期队列



		}

		private static void config(Jedis jedis){
				String parameter = "notify-keyspace-events";
				List<String> notify = jedis.configGet(parameter);
				if(notify.get(1).equals("")){
						jedis.configSet(parameter, "Ex"); //过期事件
				}
		}
}
