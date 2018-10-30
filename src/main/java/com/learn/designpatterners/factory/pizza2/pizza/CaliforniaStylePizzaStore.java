package com.learn.designpatterners.factory.pizza2.pizza;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-29 21:04
 * @Copyright: 2018
 */
public class CaliforniaStylePizzaStore extends PizzaStore {
		@Override
		public Pizza createPizza(String type) {
				if (type.equals("cheese")) {
						pizza = new CaliforniaStyleCheesePizza();
				} else if (type.equals("pepperoni")) {
						pizza = new CaliforniaStylePepperoniPizza();
				} else if (type.equals("clam")) {
						pizza = new CaliforniaStyleClamPizza();
				} else if (type.equals("veggie")) {
						pizza = new CaliforniaStyleVeggiePizza();
				}
				return pizza;
		}
}
