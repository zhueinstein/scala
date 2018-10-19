package com.learn.threadlearn.producer201808.producertest20180815;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-08-15 19:38
 * @Copyright: 2018
 */
public class Run {

		public static void main(String[] args) {
				String lock = new String("");
				ExecutorService executorService = Executors.newCachedThreadPool();

				executorService.execute(() -> {
						while (true) {
								new Producer(lock).setVal();
						}
				});
				executorService.execute(() -> {
						while (true) {
								new Consumer(lock).getVal();
						}
				});
		}
}
