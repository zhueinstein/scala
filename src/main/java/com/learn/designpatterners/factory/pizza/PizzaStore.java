package com.learn.designpatterners.factory.pizza;

/**
 *
 * @author: WeFon
 * @date: 2018-10-29 20:55
 * @Copyright: 2018
 */
public abstract class PizzaStore {

		Pizza pizza;

		public Pizza orderPizza(String type){
				// 超类的createPizza并不知道正在创建的披萨是哪一种，它只知道这个披萨可以被准备、被烘焙、被切片、被盒装
				pizza = createPizza(type);
				pizza.prepare();
				pizza.bake();
				pizza.cut();
				pizza.box();
				return pizza;
		}

		public abstract Pizza createPizza(String type);
}
