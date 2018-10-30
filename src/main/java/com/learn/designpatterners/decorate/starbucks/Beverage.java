package com.learn.designpatterners.decorate.starbucks;

/**
 * @Description: 装饰模式的Component
 * @author: WeFon
 * @date: 2018-10-28 21:05
 * @Copyright: 2018
 */
public abstract class Beverage {
		String description = "Unknown Beverage";

		private String size;

		public String getSize() {
				return size;
		}

		public void setSize(String size) {
				this.size = size;
		}

		public String getDescription() {
				return description;
		}

		/**
		 *  饮料的价钱
		 * @return
		 */
		public abstract double cost();

}
