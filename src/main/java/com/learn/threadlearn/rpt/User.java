package com.learn.threadlearn.rpt;

/**
 * @author： ZhuWeiFeng
 * @date： 2018/4/5
 */
public class User {
	private String name;

	private static User user = new User("zhangsan");
	private User(){}
	private User(String name){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		User.user = user;
	}
}
