package com.learn.threadlearn.synnonethis20180812;

/**
 * @Description: synchronized  修饰静态方法时，是对Class类进行加锁,Class 锁对类的所有对象都起作用
 * @author: WeFon
 * @date: 2018-08-12 17:43
 * @Copyright: 2018
 */
public class StaticSyncBlockService {

		synchronized public static  void  printA() {
				System.out.println(String.format("线程名称为：%s， 在 %s, 进入同步方法A", Thread.currentThread().getName(), System.currentTimeMillis()));
				try {
						Thread.sleep(1000);
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
				System.out.println(String.format("线程名称为：%s， 在 %s, 离开同步方法A", Thread.currentThread().getName(), System.currentTimeMillis()));
		}

		synchronized public static  void  printB(){
				System.out.println(String.format("线程名称为：%s， 在 %s, 进入同步方法B", Thread.currentThread().getName(), System.currentTimeMillis()));
				try {
						Thread.sleep(1000);
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
				System.out.println(String.format("线程名称为：%s， 在 %s, 离开同步方法B", Thread.currentThread().getName(), System.currentTimeMillis()));
		}
		synchronized public   void  printC(){
				System.out.println(String.format("线程名称为：%s， 在 %s, 进入同步方法C", Thread.currentThread().getName(), System.currentTimeMillis()));
				try {
						Thread.sleep(1000);
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
				System.out.println(String.format("线程名称为：%s， 在 %s, 离开同步方法C", Thread.currentThread().getName(), System.currentTimeMillis()));
		}

		public static void main(String[] args) {
				StaticSyncBlockService staticSyncBlockService = new StaticSyncBlockService();
				StaticSyncBlockService staticSyncBlockService2 = new StaticSyncBlockService();
				new Thread(() -> staticSyncBlockService.printA()).start();
				new Thread(() -> staticSyncBlockService2.printB()).start();
				new Thread(() -> staticSyncBlockService.printC()).start();
		}
}
