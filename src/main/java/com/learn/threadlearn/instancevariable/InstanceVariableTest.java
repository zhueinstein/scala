package com.learn.threadlearn.instancevariable;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author： ZhuWeiFeng
 * @date： 2018/4/5
 */
public class InstanceVariableTest{
	/**
	 * 实例变量(当InstanceVariableTest为单例的时候是共享资源)
	 */
	private int instance_i;

	private static InstanceVariableTest instanceVariableTest = new InstanceVariableTest();
	/**
	 * 把构造器私有化，确保单例
	 */
	private InstanceVariableTest(){}

	public static InstanceVariableTest getInstance(){
		return instanceVariableTest;
	}
	/**
	 * synchronized方法，为实例对象的方法加锁
	 *      操作共享资源的runInstanceVariableTest()方法添加了synchronized关键字，那么在其中一个线程执行到此实例的此方法的时候就会将该方法锁住，执行完了以后再将锁打开，
	 *      这样就保证了各个线程是按顺序去执行这一方法的，避免了多线程同时访问ivt实例的runInstanceVariableTest()方法共享资源冲突问题
	 */
	public synchronized void runInstanceVariableTest() {
		for(int i = 0; i <= 10; i++){
			instance_i = i;
			try {
				Thread.sleep(50*i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(instance_i != i){
				System.err.println("[" + Thread.currentThread().getId()   + "]当i=" + i + "获取static_i 的值:" + instance_i);
			} else {
				System.out.println("[" + Thread.currentThread().getId() + "]当i=" + i + "获取static_i 的值:" + instance_i);
			}
		}
	}
	public  void runInstanceVariableTest2() {
		for(int i = 0; i <= 10; i++){
			/**
			 * 实例级别代码块加锁
			 * runInstanceVariableTest2()方法中操作共享资源的代码块添加了synchronized关键字，那么在其中一个线程执行到此实例的此代码块的时候就会将该实例的该代码块锁住，执行完了以后再将锁打开，这样就保证了各个线程是按顺序去执行这一方法的，避免了多线程同时访问ivt实例的runInstanceVariableTest2()方法共享资源冲突问题。
			 */
			synchronized (this) {
				instance_i = i;
				try {
					Thread.sleep(50 * i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (instance_i != i) {
					System.err.println("[" + Thread.currentThread().getId() + "]当i=" + i + "获取static_i 的值:" + instance_i);
				} else {
					System.out.println("[" + Thread.currentThread().getId() + "]当i=" + i + "获取static_i 的值:" + instance_i);
				}
			}
		}
	}

	/**
	 * 只能用实例变量不能用局部变量
	 *
	 */
	ReentrantLock lock = new ReentrantLock();
	/**
	 * ReentrantLock 显示锁
	 *      runReentrantLockTest()方法是通过调用一个全局的ReentrantLock锁实例变量，然后在方法中显示的调用lock和unlock方法，为代码块加锁，这种方式更灵活可以在任何时刻打开锁。
	 */
	public void runReentrantLockTest() {
		for(int i = 0; i <= 10; i++){
			lock.lock(); // 加锁
			instance_i = i;
			try {
				Thread.sleep(50*i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(instance_i != i){
				System.err.println("[" + Thread.currentThread().getId()   + "]当i=" + i + "获取static_i 的值:" + instance_i);
			} else {
				System.out.println("[" + Thread.currentThread().getId() + "]当i=" + i + "获取static_i 的值:" + instance_i);
			}
			lock.unlock(); // 解锁
		}
	}


}
