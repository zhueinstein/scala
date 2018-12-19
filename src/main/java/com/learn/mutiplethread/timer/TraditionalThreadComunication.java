package com.learn.mutiplethread.timer;

/**
 * @ClassName: UcInfoEnterpriseExample
 *
 * @author: 亚信安全NSG WeFon
 * @date: 2018/7/16
 * @Copyright: 2018
 */
public class TraditionalThreadComunication {

	public static void main(String[] args) {
		final Business business = new Business();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 50; i++) {
					business.sub(i);
				}
			}
		}).start();

		for (int i = 1; i <= 50; i++) {
			business.main(i);
		}
	}

}

class Business {
	boolean bShouldSub = true;
	public synchronized void sub(int i) {
		while(!bShouldSub){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int j = 1; j <= 10; j++) {
			System.out.println("sub thread sequence of " + j + ", Loop is = " + i);
		}
		bShouldSub = false;
		this.notify();
	}

	public synchronized void main(int i) {
		while (bShouldSub){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int j = 1; j <= 100; j++) {
			System.out.println("main thread sequence of " + j + ", Loop is = " + i);
		}
		bShouldSub = true;
		this.notify();
	}

}