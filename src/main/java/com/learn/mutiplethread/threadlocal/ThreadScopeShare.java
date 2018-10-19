package com.learn.mutiplethread.threadlocal;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @ClassName: ThreadScopeShare
 * @Description:TODO
 * @author: 亚信安全NSG WeFon
 * @date: 2018/7/17
 * @Copyright: 2018
 */
public class ThreadScopeShare {

	private static  Map<Thread, Integer> map = new HashMap<Thread, Integer>();
	public static void main(String[] args) {
		for(int i = 0; i < 200; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() + " has put data: " + data + "  " + Thread.currentThread().toString());
					map.put(Thread.currentThread(), data);
					A a = new A();
					System.out.println(a.toString());
					a.get();
					new B().get();
				}
			}).start();

		}
	}

	static class A{
		public void get(){
			try {
				int data = map.get(Thread.currentThread());
//			System.out.println(Thread.currentThread().getName() + "   " + map);
				System.out.println("A form " + Thread.currentThread().getName() + " get data :" + data);
			}catch (Exception ex){
				System.err.println(Thread.currentThread().toString());
				ex.printStackTrace();
			}
		}
	}
	static class B{
		public void get(){
			int data = map.get(Thread.currentThread());
			System.out.println("B form " + Thread.currentThread().getName() + " get data :" + data);
		}
	}
}
