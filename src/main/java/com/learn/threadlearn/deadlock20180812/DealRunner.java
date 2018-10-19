package com.learn.threadlearn.deadlock20180812;

/**
 * @author: WeFon
 * @date: 2018-08-12 18:23
 */
public class DealRunner {

		public static void main(String[] args) throws InterruptedException {
				DealThread t = new DealThread();
				t.setFlag("a");
				new Thread(t).start();
				Thread.sleep(1000);
				t.setFlag("b");
				new Thread(t).start();
		}
}
