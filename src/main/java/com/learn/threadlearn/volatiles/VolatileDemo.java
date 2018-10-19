package com.learn.threadlearn.volatiles;

/**
 * @author： ZhuWeiFeng
 * @date： 2018/4/14
 */
public class VolatileDemo {
	static Boolean stop = false;

	public static void main(String[] args) {

		System.out.println("========Start ========");
		new Thread(){
			@Override
			public void run() {
				while(!stop){
					System.out.println("stop == " + stop);
				}
			}
		}.start();

		new Thread(){
			@Override
			public void run() {
				stop = true;
				System.out.println("stop == " + stop);
				while (true){
					System.out.println("sssssss");
				}
			}
		}.start();
		System.out.println("========End ========");
	}
}
