package com.learn.designpatterners.factory.simple;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-29 20:59
 * @Copyright: 2018
 */
public class PizzaOrderTest {

		public static void main(String[] args) {
				SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();
				PizzaStore pizzaStore = new PizzaStore(simplePizzaFactory);
				Pizza pizza = pizzaStore.orderPizza("cheese");
		}
}
