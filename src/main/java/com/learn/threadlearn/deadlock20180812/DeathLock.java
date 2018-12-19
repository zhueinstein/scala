package com.learn.threadlearn.deadlock20180812;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author: WeFon
 * @date: 2018-08-12 18:04
 * @Copyright: 2018
 */
public class DeathLock {
		public static void main(String[] args) throws InterruptedException {

				Object lock1 = new Object();
				Object lock2 = new Object();
				Thread t1 = new Thread(()->{
							synchronized (lock1){
									System.out.println(String.format("threadName = %s", Thread.currentThread().getName()));
									try {
											Thread.sleep(1000);
									} catch (InterruptedException e) {
											e.printStackTrace();
									}
									synchronized (lock2) {
											System.out.println("执行顺序 lock1 -> lock2");
									}
							}
				});
				Thread t2 = new Thread(() ->{
								synchronized (lock2){
										System.out.println(String.format("threadName = %s", Thread.currentThread().getName()));
										try {
												Thread.sleep(1000);
										} catch (InterruptedException e) {
												e.printStackTrace();
										}
										synchronized (lock1){
												System.out.println("执行顺序 lock2 -> lock1");
										}
								}
						});
			t1.start();
			Thread.sleep(1000);
			t2.start();
		}
}
