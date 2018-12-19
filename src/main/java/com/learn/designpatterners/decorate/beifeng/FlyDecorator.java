package com.learn.designpatterners.decorate.beifeng;

/**
 *
 * @author: WeFon
 * @date: 2018-10-28 19:39
 * @Copyright: 2018
 */
public class FlyDecorator extends CarDecorator{

		public FlyDecorator(Car car) {
				super(car);
		}

		@Override
		public void fun() {
				this.getCar().desc();
				System.out.println("我可以给车装饰机翼，可以飞了");
		}
}
