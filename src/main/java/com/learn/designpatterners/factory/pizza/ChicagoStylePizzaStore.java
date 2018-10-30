package com.learn.designpatterners.factory.pizza;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-29 21:04
 * @Copyright: 2018
 */
public class ChicagoStylePizzaStore extends PizzaStore {
		@Override
		public Pizza createPizza(String type) {
				PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();
				if (type.equals("cheese")) {
						pizza = new CheesePizza(ingredientFactory);
						pizza.setName("Chicago Style Cheese Pizza");
				} else if (type.equals("pepperoni")) {
						pizza = new CheesePizza(ingredientFactory);
						pizza.setName("Chicago Style pepperoni Pizza");
				} else if (type.equals("clam")) {
						pizza = new CheesePizza(ingredientFactory);
						pizza.setName("Chicago Style clam Pizza");
				} else if (type.equals("veggie")) {
						pizza = new CheesePizza(ingredientFactory);
						pizza.setName("Chicago Style veggie Pizza");
				}
				return pizza;
		}
}
