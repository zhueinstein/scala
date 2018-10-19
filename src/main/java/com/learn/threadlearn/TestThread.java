package com.learn.threadlearn;

import java.util.HashSet;

/**
 * @author： ZhuWeiFeng
 * @date： 2018/3/24
 */
public class TestThread {

	public static void main(String[] args) throws InterruptedException {
		/*RunnableDemo R1 = new RunnableDemo("Thread-1");
		R1.start();
		RunnableDemo R2 = new RunnableDemo("Thread-2");
		R2.start();

		ThreadDemo T1 = new ThreadDemo("ThreadDemo-1");
		T1.starts();
		ThreadDemo T2 = new ThreadDemo("ThreadDemo-2");
		T2.starts();*/
		Runnable  runnable = () -> System.out.println(Thread.currentThread().getName());

		Thread t1 = new Thread(runnable,"Thread---1");
		Thread t2 = new Thread(runnable,"Thread---2");
		Thread t3 = new Thread(runnable,"Thread---3");
		t1.start();
//		t1.join();
		t2.start();
//		t2.join();
		t3.start();
//		t3.join();
	}
}
