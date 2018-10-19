package com.learn.threadlearn;

import java.util.concurrent.Callable;

/**
 * @author： ZhuWeiFeng
 * @date： 2018/3/24
 */
public class MyCallable implements Callable<Integer>{
	int x = 0;
	int y = 0;

	public MyCallable(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public MyCallable() {
	}

	@Override
	public Integer call() throws Exception {
		return x + y;
	}
}
