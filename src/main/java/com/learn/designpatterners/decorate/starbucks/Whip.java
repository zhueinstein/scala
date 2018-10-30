package com.learn.designpatterners.decorate.starbucks;

/**
 * @Description:  装饰者模式的concrete decorator
 * @author: WeFon
 * @date: 2018-10-28 21:17
 * @Copyright: 2018
 */
public class Whip extends CondimentDecorator {
		Beverage beverage;

		public Whip(Beverage beverage) {
				this.beverage = beverage;
		}

		@Override
		public String getDescription() {
				return beverage.getDescription() + ", Whip";
		}

		@Override
		public double cost() {
				if(Volume.TALL.getVolume().equals(beverage.getSize())) {
						return 0.1110 + beverage.cost();
				}else if(Volume.GRANDE.getVolume().equals(beverage.getSize())){
						return 0.15 + beverage.cost();
				}else{
						return 0.20 + beverage.cost();
				}
		}
}
