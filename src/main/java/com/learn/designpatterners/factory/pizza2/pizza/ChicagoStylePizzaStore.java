package com.learn.designpatterners.factory.pizza2.pizza;

/**
 *
 * @author: WeFon
 * @date: 2018-10-29 21:04
 * @Copyright: 2018
 */
public class ChicagoStylePizzaStore extends PizzaStore {
		@Override
		public Pizza createPizza(String type) {
				if (type.equals("cheese")) {
						pizza = new ChicagoStyleCheesePizza();
				} else if (type.equals("pepperoni")) {
						pizza = new ChicagoStylePepperoniPizza();
				} else if (type.equals("clam")) {
						pizza = new ChicagoStyleClamPizza();
				} else if (type.equals("veggie")) {
						pizza = new ChicagoStyleVeggiePizza();
				}
				return pizza;
		}
}
