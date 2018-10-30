package com.learn.designpatterners.decorate.beifeng;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-28 19:41
 * @Copyright: 2018
 */
public class SwimDecorator extends CarDecorator {
		public SwimDecorator(Car car) {
				super(car);
		}

		@Override
		public void fun() {
				this.getCar().desc();
				System.out.println("我可以给车装饰涡轮机， 可以游泳了");
		}
}
