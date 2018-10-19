package com.learn.threadlearn.deadlock20180812;

/**
 * @author: WeFon
 * @date: 2018-08-12 18:20
 */
public class DealThread implements Runnable{
		private volatile  String userName;
		private Object lock1 = new Object();
		private Object lock2 = new Object();
		public void setFlag(String userName){
				this.userName = userName;
		}


		@Override
		public void run() {
				if(userName.equals("a")){
						synchronized (lock1){
								System.out.println(String.format("username = %s", userName));
								try {
										Thread.sleep(3000);
								} catch (InterruptedException e) {
										e.printStackTrace();
								}
								synchronized (lock2) {
										System.out.println("执行顺序 lock1 -> lock2");
								}
						}

				}
				if(userName.equals("b")){
						synchronized (lock2){
								System.out.println(String.format("username = %s", userName));
								try {
										Thread.sleep(3000);
								} catch (InterruptedException e) {
										e.printStackTrace();
								}
								synchronized (lock1){
										System.out.println("执行顺序 lock2 -> lock1");
								}
						}

				}
		}
}
