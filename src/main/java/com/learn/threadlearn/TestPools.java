package com.learn.threadlearn;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author： ZhuWeiFeng
 * @date： 2018/3/24
 */
public class TestPools {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		RunnableDemo R1 = new RunnableDemo("Thread-1");
		executorService.submit(R1);
		System.out.println("---------------");
		executorService.submit(R1);
		executorService.shutdown();

	}
}
