package com.learn.threadlearn;

/**
 * @author： ZhuWeiFeng
 * @date： 2018/3/24
 */
public class ThreadDemo extends Thread{
	private Thread thread;
	private String threadName;

	public ThreadDemo(String threadName) {
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
	public void starts(){
		System.out.println("Starting " +  threadName );
		if(null == thread){
			thread = new Thread(this, threadName);
			thread.start();
		}
	}

}
