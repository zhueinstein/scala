package com.learn.threadlearn.staticvariable;

/**
 * @author： ZhuWeiFeng
 * @date： 2018/4/5
 */
public class StaticVariableTest extends Thread{
	/**
	 * 静态变量(共享资源)
	 */
	private  static  int static_i;

	@Override
	public void run() {
		for(int i = 0; i <= 10; i++){
			/**
			 *  类级别对代码块加锁
			 */
//			synchronized (StaticVariableTest.class) {
				static_i = i;
				try {
					Thread.sleep(50 * i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (static_i != i) {
					System.err.println("[" + Thread.currentThread().getId() + "]当i=" + i + "获取static_i 的值:" + static_i);
				} else {
					System.out.println("[" + Thread.currentThread().getId() + "]当i=" + i + "获取static_i 的值:" + static_i);
				}
//			}
		}
	}

}
