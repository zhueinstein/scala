package com.learn.designpatterners.decorate.starbucks;

/**
 * @Description: 装饰模式的concrete Component
 * @author: WeFon
 * @date: 2018-10-28 21:12
 * @Copyright: 2018
 */
public class Espresso extends  Beverage{

		public Espresso() {
				description = "Espresso";
		}

		@Override
		public double cost() {
				return 1.99;
		}

}
