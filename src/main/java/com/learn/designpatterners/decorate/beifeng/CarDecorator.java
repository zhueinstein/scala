package com.learn.designpatterners.decorate.beifeng;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-28 19:35
 * @Copyright: 2018
 */
public abstract class CarDecorator extends Car{
		private Car car;

		public CarDecorator(Car car) {
				this.car = car;
		}

		public Car getCar() {
				return car;
		}

		/**
		 * 添加新的修饰的功能
		 */
		public abstract void fun();

}
