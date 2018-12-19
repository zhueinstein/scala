package com.learn.designpatterners.factory.pizza;

/**
 *
 * @author: WeFon
 * @date: 2018-10-29 21:04
 * @Copyright: 2018
 */
public class NyStylePizzaStore extends PizzaStore {
		@Override
		public Pizza createPizza(String type) {
				PizzaIngredientFactory ingredientFactory = new NyPizzaIngredientFactory();
				if(type.equals("cheese")){
						pizza = new CheesePizza(ingredientFactory);
						pizza.setName("NY Style Cheese Pizza");
				}else if(type.equals("pepperoni")){
						pizza = new PepperoniPizza(ingredientFactory);
						pizza.setName("NY Style pepperoni Pizza");
				}else if(type.equals("clam")){
						pizza = new ClamPizza(ingredientFactory);
						pizza.setName("NY Style clam Pizza");
				}else if(type.equals("veggie")){
						pizza = new VeggiePizza(ingredientFactory);
						pizza.setName("NY Style veggie Pizza");
				}
				return pizza;
		}
}
