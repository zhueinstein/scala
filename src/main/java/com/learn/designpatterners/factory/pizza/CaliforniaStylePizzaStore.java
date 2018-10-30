package com.learn.designpatterners.factory.pizza;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-29 21:04
 * @Copyright: 2018
 */
public class CaliforniaStylePizzaStore extends PizzaStore {
		@Override
		public Pizza createPizza(String type) {
				PizzaIngredientFactory ingredientFactory = new CaliforniaPizzaIngredientFactory();
				if (type.equals("cheese")) {
						pizza = new CheesePizza(ingredientFactory);
						pizza.setName("California Cheese");
				} else if (type.equals("pepperoni")) {
						pizza = new PepperoniPizza(ingredientFactory);
						pizza.setName("California Pepperoni");
				} else if (type.equals("clam")) {
						pizza = new ClamPizza(ingredientFactory);
						pizza.setName("California clam");
				} else if (type.equals("veggie")) {
						pizza = new VeggiePizza(ingredientFactory);
						pizza.setName("California veggie");
				}
				return pizza;
		}
}
