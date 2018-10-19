package com.learn.threadlearn.commuication201808.waitold;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-08-15 15:03
 * @Copyright: 2018
 */
public class Add {
		/**
		 * 加法
 		 */

		private String lock;

		public Add(String lock) {
				super();
				this.lock = lock;
		}

		public void add(){
				synchronized (lock){
						ValueObject.list.add("anything");
						lock.notifyAll();
				}
		}

}
