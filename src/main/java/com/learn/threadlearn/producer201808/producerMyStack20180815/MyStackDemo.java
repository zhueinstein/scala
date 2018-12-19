package com.learn.threadlearn.producer201808.producerMyStack20180815;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author: WeFon
 * @date: 2018-08-15 22:49
 * @Copyright: 2018
 */
public class MyStackDemo {
		static List<String> list = new ArrayList<>(1);

		public synchronized void push() throws InterruptedException {
				if(list.size() == 1){
						this.wait();
				}
				list.add("anyThing" + System.nanoTime());
				this.notify();
				System.out.println("Push list.size = " + list.size());
		}

		public synchronized String pop() throws InterruptedException {
				if(list.size() == 0){
						this.wait();
				}
				String value = list.get(0);
				list.remove(0);
				this.notify();
				System.out.println("Pop List.size = " + list.size());
				return value;
		}

		public static void main(String[] args) {
				ExecutorService executorService = Executors.newCachedThreadPool();
				MyStackDemo myStackDemo = new MyStackDemo();
				// 生产者
				executorService.execute(() -> {
						while (true) {
								try {
										myStackDemo.push();
								} catch (InterruptedException e) {
										e.printStackTrace();
								}
						}
				});
				// 消费者
				executorService.execute(() -> {
						while (true) {
								try {
										System.out.println("Pop value = " + myStackDemo.pop());
								} catch (InterruptedException e) {
										e.printStackTrace();
								}
						}
				});
		}
}
