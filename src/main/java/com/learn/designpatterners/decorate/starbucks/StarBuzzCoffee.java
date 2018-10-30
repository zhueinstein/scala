package com.learn.designpatterners.decorate.starbucks;

/**
 * @Description: 测试类
 * @author: WeFon
 * @date: 2018-10-28 21:25
 * @Copyright: 2018
 */
public class StarBuzzCoffee {

		public static void main(String[] args) {
				Beverage beverage = new Espresso();
				System.out.println(beverage.getDescription() + " $" + beverage.cost()) ;

				Beverage beverage2 = new DarkRoast();
				beverage2 = new Mocha(beverage2);
				beverage2 = new Mocha(beverage2);
				beverage2.setSize(Volume.TALL.getVolume());
				beverage2 = new Whip(beverage2);
				System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

				Beverage beverage3 = new HouseBlend();
				beverage3 = new Soy(beverage3);
				beverage3 = new Mocha(beverage3);
				beverage3 = new Whip(beverage3);
				System.out.println(beverage3.getDescription() + " $" + beverage3.cost());

		}
}
