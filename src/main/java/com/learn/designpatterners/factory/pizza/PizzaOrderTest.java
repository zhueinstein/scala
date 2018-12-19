package com.learn.designpatterners.factory.pizza;

/**
 *
 * @author: WeFon
 * @date: 2018-10-29 20:59
 * @Copyright: 2018
 */
public class PizzaOrderTest {

		public static void main(String[] args) {
				PizzaStore nyPizzaStore = new NyStylePizzaStore();
				Pizza pizza = nyPizzaStore.orderPizza("cheese");

				PizzaStore chicagoPizzaStore = new ChicagoStylePizzaStore();
				chicagoPizzaStore.orderPizza("cheese");
		}
}
