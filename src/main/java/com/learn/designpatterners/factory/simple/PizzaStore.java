package com.learn.designpatterners.factory.simple;

/**
 *
 * @author: WeFon
 * @date: 2018-10-29 20:55
 * @Copyright: 2018
 */
public  class PizzaStore {
		SimplePizzaFactory simplePizzaFactory;

		public PizzaStore(SimplePizzaFactory simplePizzaFactory) {
				this.simplePizzaFactory = simplePizzaFactory;
		}

		public Pizza orderPizza(String type){
				Pizza pizza;

				pizza = simplePizzaFactory.createPizza(type);

				pizza.prepare();
				pizza.bake();
				pizza.cut();
				pizza.box();
				return pizza;
		}
}
