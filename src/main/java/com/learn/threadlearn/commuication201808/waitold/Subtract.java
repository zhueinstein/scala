package com.learn.threadlearn.commuication201808.waitold;

/**
 *
 * @author: WeFon
 * @date: 2018-08-15 15:05
 * @Copyright: 2018
 */
public class Subtract {
		/**
		 * 减法
		 */
		private String lock;

		public Subtract(String lock) {
				super();
				this.lock = lock;
		}

		public void subtract() throws InterruptedException {
				synchronized (lock){
						/**
						 * 此处if 与while的区别就是，if只执行一次，当两个线程的lock都被唤醒时，
						 * if都往下走，回报数组越界，而while，还是会先判断当前的条件，数组长度为0，继续阻塞
						 */
					while (ValueObject.list.size() == 0){
							System.out.println("wait begin threadName " + Thread.currentThread().getName());
							lock.wait();
							System.out.println("wait end threadName " + Thread.currentThread().getName());
					}
					ValueObject.list.remove(0);
					System.out.println("list size = " + ValueObject.list.size());
				}
		}
}
