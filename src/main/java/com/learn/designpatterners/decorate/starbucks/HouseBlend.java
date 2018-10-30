package com.learn.designpatterners.decorate.starbucks;

/**
 * @Description: 装饰模式的concrete Component
 * @author: WeFon
 * @date: 2018-10-28 21:15
 * @Copyright: 2018
 */
public class HouseBlend extends Beverage {

		public HouseBlend() {
				description = "House Bent";
		}

		@Override
		public double cost() {
				return .89;
		}

}
