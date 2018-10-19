package com.learn.threadlearn.instancevariable;

/**
 * @author： ZhuWeiFeng
 * @date： 2018/4/5
 */
public class InstanceThread extends Thread{
	@Override
	public void run() {
		InstanceVariableTest ivt = InstanceVariableTest.getInstance();
		ivt.runReentrantLockTest();
	}

}
