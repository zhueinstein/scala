package com.learn.threadlearn.condition20180805;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ConditionCommunication
 * @Description: 三个线程之间的condition的通信
 * @author: 亚信安全NSG WeFon
 * @date: 2018/8/4
 * @Copyright: 2018
 */
public class ConditionCommunication {
		static class Business {
				static int signal = 10;
				Lock lock = new ReentrantLock();
				Condition conditionA = lock.newCondition();
				Condition conditionB = lock.newCondition();
				Condition conditionC = lock.newCondition();
				public void loopTen(int loopi) {
						lock.lock();
						try {

								while (signal != 10) {
										conditionA.await();
								}
								for (int i = 1; i <= 10; i++) {
										System.out.println("Loop of ten :  " + i + "  from " + loopi);
								}
								conditionB.signalAll();
								signal = 20;
						} catch (Exception ex) {

						} finally {
								lock.unlock();
						}

				}

				public void loopTwenty(int loopi) {
						lock.lock();
						try {
								while (signal != 20) {
										conditionB.await();
								}
								for (int i = 1; i <= 20; i++) {
										System.out.println("Loop of twenty : " + i + " from " + loopi);
								}
								conditionC.signalAll();
								signal = 30;
						} catch (Exception ex) {

						} finally {
								lock.unlock();
						}
				}
				public void loopThirty(int loopi){
						lock.lock();
						try{
								while (signal != 30) {
										conditionC.await();
								}
								for (int i = 1; i <= 30; i++) {
										System.out.println("Loop of thirty : " + i + " from " + loopi);
								}
								conditionA.signalAll();
								signal = 10;
						}catch (Exception ex){

						}
						finally {
								lock.unlock();
						}

				}
		}

		public static void main(String[] args) {
				Business business = new Business();

				new Thread(new Runnable() {
						@Override
						public void run() {
								for (int i = 1; i <= 10; i++) {
										business.loopTen(i);
								}
						}
				}).start();

				new Thread(new Runnable() {
						@Override
						public void run() {
								for(int i = 1; i <= 10; i++) {
										business.loopTwenty(i);
								}
						}
				}).start();

				new Thread(new Runnable() {
						@Override
						public void run() {
								for(int i = 1; i <= 10; i++) {
										business.loopThirty(i);
								}
						}
				}).start();
		}
}
