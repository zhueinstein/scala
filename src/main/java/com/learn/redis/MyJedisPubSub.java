package com.learn.redis;

import redis.clients.jedis.JedisPubSub;

/**
 * @Description: 消息过期通知实现类
 * @author: WeFon
 * @date: 2018-10-23 14:21
 * @Copyright: 2018
 */
public class MyJedisPubSub extends JedisPubSub {

		@Override
		public void onPMessage(String pattern, String channel, String message) {
				System.out.println(
							"pattern = [" + pattern + "], channel = [" + channel + "], message = [" + message + "]");
				//收到消息 key的键值，处理过期提醒
		}


		@Override
		public void onPUnsubscribe(String pattern, int subscribedChannels) {
				System.out.println("onPSubscribe " + pattern + " " + subscribedChannels);
		}

}
