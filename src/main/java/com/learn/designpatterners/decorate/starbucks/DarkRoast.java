package com.learn.designpatterners.decorate.starbucks;

/**
 * @Description: 装饰模式的concrete Component
 * @author: WeFon
 * @date: 2018-10-28 21:15
 * @Copyright: 2018
 */
public class DarkRoast extends Beverage {

		public DarkRoast() {
				description = "Dark Roast";
		}

		@Override
		public double cost() {
				return .89;
		}

}
