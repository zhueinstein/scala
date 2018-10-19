package com.learn.threadlearn.instancevariable;

/**
 * @author： ZhuWeiFeng
 * @date： 2018/4/5
 */
public class InstanceMain {
	public static void main(String[] args) {
		// 启动尽量多的线程才能很容易的模拟出问题
		for (int i = 0; i < 10; i++) {
			InstanceThread t = new InstanceThread();
			t.start();
		}

	}
}
