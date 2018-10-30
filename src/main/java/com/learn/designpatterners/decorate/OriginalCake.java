package com.learn.designpatterners.decorate;

/**
 * @Description: 原味饼，要被装饰的对象抽象
 * @author: WeFon
 * @date: 2018-10-26 16:40
 * @Copyright: 2018
 */
public abstract class OriginalCake {
		public String description = "我是原饼";

		public String getDescription() {
				return description;
		}

		/**
		 * 饼的价钱
		 * @return
		 */
		public abstract double price();

}
