package com.learn.threadlearn;

/**
 * @author： ZhuWeiFeng
 * @date： 2018/3/24
 * @description 实现Runnable接口新建一个线程, 重写run()方法
 */
public class RunnableDemo implements Runnable{
	private Thread thread;
	private String threadName;

	public RunnableDemo(String threadName) {
		this.threadName = threadName;
		System.out.println("Creating " + threadName);
	}

	@Override
	public void run() {
		System.out.println("Running " + threadName);
		try{
			for (int i = 4; i > 0; i--){
				System.out.println("Thread: " + threadName + ", " + i);
				// 让线程睡眠一会
				Thread.sleep(50);
			}
		}catch (Exception ex){
			System.out.println("Thread " +  threadName + " interrupted.");
		}
		System.out.println("Thread " +  threadName + " exiting.");
	}
	public void start(){
		System.out.println("Starting " +  threadName );
		if(null == thread){
			thread = new Thread(this, threadName);
			thread.setPriority(10);
			thread.start();
		}
	}

}
