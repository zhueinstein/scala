package com.learn.designpatterners.decorate.starbucks;

/**
 * @Description: 装饰模式的concrete Component
 * @author: WeFon
 * @date: 2018-10-28 21:15
 * @Copyright: 2018
 */
public class Decaf extends Beverage {

		public Decaf() {
				description = "Decaf";
		}

		@Override
		public double cost() {
				return .89;
		}

}
