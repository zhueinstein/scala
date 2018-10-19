package com.learn.threadlearn.staticvariable;

/**
 * @author： ZhuWeiFeng
 * @date： 2018/4/5
 */
public class StaticMain {

	public static void main(String[] args) {
		// 启动尽量多的线程才能很容易的模拟出问题
		for (int i = 0; i < 10; i++) {
			StaticVariableTest t = new StaticVariableTest();
			t.start();
		}

	}
}
