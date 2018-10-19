package com.learn.mutiplethread.threadlocal;

import java.util.Random;

/**
 * @ClassName: ThreadLocalShare
 * @Description: 多线程ThreadLocal使用， 实现线程内的共享变量， 线程外的变量独立性
 * @author: 亚信安全NSG WeFon
 * @date: 2018/7/18
 * @Copyright: 2018
 */
public class ThreadLocalShare {

	public static void main(String[] args) {
		for(int i = 0; i < 2; i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() + " has put data: " + data);
					User.getThreadInstance().setName("name" + data);
					User.getThreadInstance().setAge(data);
					new Aemo().get();
					new Bemo().get();
				}
			}).start();
		}
	}

	static class Aemo{
		public void get(){
			System.out.println("A from "  + Thread.currentThread().getName() + ", get Name: " + User.getThreadInstance().getName());
		}
	}
	static class Bemo{
		public void get(){
			System.out.println("B from "  + Thread.currentThread().getName() + ", get Name: " + User.getThreadInstance().getName());
		}
	}

}

class User {
	private String name;
	private int age;

	private User() {
	}
	private static ThreadLocal<User> threadLocal = new ThreadLocal<>();
	private static User instance = threadLocal.get();
	public static User getThreadInstance(){
		if(instance == null){
			instance = new User();
			threadLocal.set(instance);
		}
		return instance;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
