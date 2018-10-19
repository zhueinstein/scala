package com.learn.threadlearn.producer201808.producertest20180815;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-08-15 17:11
 * @Copyright: 2018
 */
public class Producer {
		private String lock;

		public Producer(String lock) {
				this.lock = lock;
		}

		public void setVal() {
				synchronized (lock) {
						if (!ValueObject.value.equals("")) {
								try {
										lock.wait();
								} catch (InterruptedException e) {
										e.printStackTrace();
								}
						}
						String value = System.currentTimeMillis() + "_" + System.nanoTime();
						System.out.println(value);
						ValueObject.value = value;
						lock.notify();
				}
		}
}
