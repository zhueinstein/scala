package com.learn.designpatterners.decorate.starbucks;

/**
 * @Description:  装饰模式的Decorator Component
 * @author: WeFon
 * @date: 2018-10-28 21:08
 * @Copyright: 2018
 */
public abstract class CondimentDecorator extends Beverage {

		/**
		 * 所有的装饰对象都必须要重新实现getDescription()方法
		 * @return
		 */
		@Override
		public abstract String getDescription();

}
