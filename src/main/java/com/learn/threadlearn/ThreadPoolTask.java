package com.learn.threadlearn;

import java.util.concurrent.*;

/**
 * @author： ZhuWeiFeng
 * @date： 2018/3/24
 */
public class ThreadPoolTask {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		MyCallable c1 = new MyCallable(100, 200);
		MyCallable c2 = new MyCallable(10, 20);
		Future<Integer> result = executorService.submit(c1);
		Integer sum = result.get();
		System.out.println("sum = " + sum);
		result = executorService.submit(c2);
		System.out.println("sum = " + result.get());

	}
}
