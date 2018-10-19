package com.learn.threadlearn.daemon20180811;

/**
 * @ClassName: DeamonTest
 * @Description: 守护线程
 * @author: 亚信安全NSG WeFon
 * @date: 2018/8/11
 * @Copyright: 2018
 */
public class DeamonTest {
		public static void main(String[] args) throws InterruptedException {
				Thread thread = new Thread(new Runnable() {
						@Override
						public void run() {
								int index = 0;
								while (true) {
										System.out.println("守护线程正在打印    index= " + index);
										index++;
										try {
												Thread.sleep(500);
										} catch (InterruptedException e) {
												e.printStackTrace();
										}
								}
						}
				});

				thread.setDaemon(true);
				thread.start();
				Thread.sleep(5000);
				System.out.println("主线程结束， 守护线程也不打印了 !");
		}
}
