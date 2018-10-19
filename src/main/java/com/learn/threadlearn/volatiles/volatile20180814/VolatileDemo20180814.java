package com.learn.threadlearn.volatiles.volatile20180814;

/**
 * @Description: volatile 不具备同步性
 * @author: WeFon
 * @date: 2018-08-14 22:32
 * @Copyright: 2018
 */
public class VolatileDemo20180814 extends Thread {
		volatile public static int count;

		/*synchronized */public void addCount() {
				for (int i = 0; i < 100; i++) {
						count++;
				}
				System.out.println(count);
		}

		@Override
		public void run() {
				addCount();
		}
}
