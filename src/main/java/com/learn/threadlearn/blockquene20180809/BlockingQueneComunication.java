package com.learn.threadlearn.blockquene20180809;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @ClassName: BlockingQueneComunication
 * @Description:TODO
 * @author: 亚信安全NSG WeFon
 * @date: 2018/8/9
 * @Copyright: 2018
 */
public class BlockingQueneComunication {

		public static void main(String[] args) {
				 Business business = new Business();
				new Thread(new Runnable() {
						@Override
						public void run() {
								for(int i = 1; i <= 10; i++){
										try {
												business.sub1(i);
										} catch (InterruptedException e) {
												e.printStackTrace();
										}
								}
						}
				}).start();
				new Thread(new Runnable() {
						@Override
						public void run() {
								for(int i = 1; i <= 10; i++){
										try {
												business.sub2(i);
										} catch (InterruptedException e) {
												e.printStackTrace();
										}
								}
						}
				}).start();
		}

}

class Business{
		BlockingQueue<Integer> queueA = new ArrayBlockingQueue<Integer>(1);
		BlockingQueue<Integer> queueB = new ArrayBlockingQueue<Integer>(1);
		{
				try {
						queueB.put(1);
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
		}
		public void sub1(int loop) throws InterruptedException {
				queueA.put(1);
				for (int i = 1; i <= 10; i++){
						System.out.println(String.format("Loop %s of sub1 , out Loop is %s", i, loop));
				}
				queueB.take();

		}

		public void sub2(int loop) throws InterruptedException {
				queueB.put(1);
				for (int i = 1; i <= 20; i++){
						System.out.println(String.format("Loop %s of sub2 , out Loop is %s", i, loop));
				}
				queueA.take();
		}
}
