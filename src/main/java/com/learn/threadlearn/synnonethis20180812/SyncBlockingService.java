package com.learn.threadlearn.synnonethis20180812;

/**
 * @Description: 验证非this对象作为synchronized 同步块的对象锁
 * 				下面的代码中，使用不同的字符串，移动Thread.sleep()；代码的位置进行验证
 * @author: WeFon
 * @date: 2018-08-12 16:57
 * @Copyright: 2018
 */

public class SyncBlockingService {

		private String userName;
		private String password;


		public void setUserNamePassword(String userName, String password) {
				String anyString = new String();
				synchronized (anyString) {

						try {
								System.out.println(String.format("线程名称为：%s， 在 %s, 进入同步块", Thread.currentThread().getName(), System.currentTimeMillis()));
								this.userName = userName;
								Thread.sleep(3000);
								this.password = password;
								System.out.println(String.format("线程名称为：%s， 在 %s,离开同步块", Thread.currentThread().getName(), System.currentTimeMillis()));
						} catch (InterruptedException e) {
								e.printStackTrace();
						}
				}
		}

		public static void main(String[] args) {
			SyncBlockingService syncBlockingService = new SyncBlockingService();
			new Thread( () -> syncBlockingService.setUserNamePassword("a", "ap")).start();
			new Thread(() -> syncBlockingService.setUserNamePassword("b", "bp")).start();


		}
}
