package com.learn.designpatterners.decorate.starbucks;

/**
 * @Description:  装饰者模式的concrete decorator
 * @author: WeFon
 * @date: 2018-10-28 21:17
 * @Copyright: 2018
 */
public class Soy extends CondimentDecorator {
		Beverage beverage;

		public Soy(Beverage beverage) {
				this.beverage = beverage;
		}

		@Override
		public String getDescription() {
				return beverage.getDescription() + ", Soy";
		}

		@Override
		public double cost() {
				return 0.10 + beverage.cost();
		}
}
