package com.learn.threadlearn.producer201808.producertest20180815;

import sun.jvm.hotspot.code.ObjectValue;

import javax.swing.text.html.ObjectView;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-08-15 19:34
 * @Copyright: 2018
 */
public class Consumer {
		private String  lock;

		public Consumer(String lock) {
				this.lock = lock;
		}

		public void getVal(){
				synchronized (lock){
						if(ValueObject.value.equals("")){
								try {
										lock.wait();
								} catch (InterruptedException e) {
										e.printStackTrace();
								}
						}
						ValueObject.value = "";
						lock.notify();
				}
		}
}
