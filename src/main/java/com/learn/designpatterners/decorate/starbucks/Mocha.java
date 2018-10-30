package com.learn.designpatterners.decorate.starbucks;

/**
 * @Description:  装饰者模式的concrete decorator
 * @author: WeFon
 * @date: 2018-10-28 21:17
 * @Copyright: 2018
 */
public class Mocha extends CondimentDecorator {
		Beverage beverage;

		public Mocha(Beverage beverage) {
				this.beverage = beverage;
		}

		@Override
		public String getDescription() {
				return beverage.getDescription() + ", Mocha";
		}

		@Override
		public double cost() {
				return 0.20 + beverage.cost();
		}
}
