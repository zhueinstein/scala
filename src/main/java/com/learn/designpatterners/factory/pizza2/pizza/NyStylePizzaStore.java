package com.learn.designpatterners.factory.pizza2.pizza;

/**
 *
 * @author: WeFon
 * @date: 2018-10-29 21:04
 * @Copyright: 2018
 */
public class NyStylePizzaStore extends PizzaStore {
		@Override
		public Pizza createPizza(String type) {
				if(type.equals("cheese")){
						pizza = new NyStyleCheesePizza();
				}else if(type.equals("pepperoni")){
						pizza = new NyStylePepperoniPizza();
				}else if(type.equals("clam")){
						pizza = new NyStyleClamPizza();
				}else if(type.equals("veggie")){
						pizza = new NyStyleVeggiePizza();
				}
				return pizza;
		}
}
