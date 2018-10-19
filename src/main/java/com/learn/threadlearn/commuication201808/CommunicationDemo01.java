package com.learn.threadlearn.commuication201808;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: wait() , notify() 进行线程间的通信
 * @author: WeFon
 * @date: 2018-08-14 23:15
 * @Copyright: 2018
 */
public class CommunicationDemo01 {

		public static void main(String[] args) {
				String lock = new String();

				ExecutorService executorService = Executors.newCachedThreadPool();

				executorService.execute(() -> {
						synchronized (lock) {
								System.out.println("我是a，我执行了");
								try {
										lock.wait(3000);
								} catch (InterruptedException e) {
										e.printStackTrace();
								}
								System.out.println("我是a， 我被通知执行后，执行完毕");
						}
				});
				executorService.execute(() -> {
						synchronized (lock) {
								System.out.println("我是c，我执行了");
								try {
										lock.wait(3000);
								} catch (InterruptedException e) {
										e.printStackTrace();
								}
								System.out.println("我是c， 我被通知执行后，执行完毕");
						}
				});
				executorService.execute(() -> {
						synchronized (lock) {
								System.out.println("我是b，我执行了");
								System.out.println("我是b， 执行完毕后通知a继续执行");
								lock.notify();
						}
				});
		}
}
