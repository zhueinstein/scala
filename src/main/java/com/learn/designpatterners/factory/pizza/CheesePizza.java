package com.learn.designpatterners.factory.pizza;

/**
 *
 * @author: WeFon
 * @date: 2018-10-29 20:54
 * @Copyright: 2018
 */
public class CheesePizza extends Pizza {
		PizzaIngredientFactory ingredientFactory;

		public CheesePizza(PizzaIngredientFactory ingredientFactory) {
				this.ingredientFactory = ingredientFactory;
		}

		@Override
		void prepare() {
				System.out.println("Preparing " + name);
				dough = ingredientFactory.createDough();
				sauce = ingredientFactory.createSauce();
				cheese = ingredientFactory.createCheese();
		}
}
