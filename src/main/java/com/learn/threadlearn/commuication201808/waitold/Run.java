package com.learn.threadlearn.commuication201808.waitold;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author: WeFon
 * @date: 2018-08-15 15:10
 * @Copyright: 2018
 */
public class Run {

		public static void main(String[] args) throws InterruptedException {
				ExecutorService executorService = Executors.newCachedThreadPool();
				String lock = new String("");
				executorService.execute(() -> {
						try {
								new Subtract(lock).subtract();
						} catch (InterruptedException e) {
								e.printStackTrace();
						}
				});
				executorService.execute(() -> {
						try {
								new Subtract(lock).subtract();
						} catch (InterruptedException e) {
								e.printStackTrace();
						}
				});
				Thread.sleep(1000);
				executorService.execute(() -> new Add(lock).add());

		}
}
