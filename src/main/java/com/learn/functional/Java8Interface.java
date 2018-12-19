package com.learn.functional;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-11-20 17:41
 * @Copyright: 2018
 */
public interface Java8Interface {
		/**
		 * Java 8允许在接口中加入具体方法。接口中的具体方法有两种，default方法和static方法，identity()就是Function接口的一个静态方法。
		 * @param name
		 * @return
		 */
		static String getSomething(String name){
				return "Lily " + name;
		}
}
