package com.learn.threadlearn.blockquene20180809;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @ClassName: BlockQueneTest
 * @Description: 阻塞队列
 * @author: 亚信安全NSG WeFon
 * @date: 2018/8/9
 * @Copyright: 2018
 */
public class BlockQueneTest {

		private static BlockingQueue blockingQueue = new ArrayBlockingQueue(3);

		public static void main(String[] args){
				for(int i = 0; i < 2; i++){
						new Thread(new Runnable() {
								@Override
								public void run() {
										try {
												while (true) {
														Thread.sleep(new Random().nextInt(1000));
														System.out.println(String.format("线程准备放数据, 当前阻塞队列中共有%s数据", blockingQueue.size()));
														blockingQueue.put(1);
														System.out.println(String.format("线程已经放数据进去，当前队列中有%s条数据", blockingQueue.size()));
												}
										} catch (InterruptedException e) {
												e.printStackTrace();
										}

								}
						}).start();
				}
				new Thread(new Runnable() {
						@Override
						public void run() {
								try {
										while (true) {
												Thread.sleep(new Random().nextInt(1000));
												System.out.println(String.format("线程准备取出数据，当前队列中有%s条数据", blockingQueue.size()));
												blockingQueue.take();
												System.out.println(String.format("线程已经取出数据，当前队列中有%s条数据", blockingQueue.size()));
										}
								} catch (InterruptedException e) {
										e.printStackTrace();
								}
						}
				}).start();
		}

}
