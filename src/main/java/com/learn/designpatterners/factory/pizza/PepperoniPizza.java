package com.learn.designpatterners.factory.pizza;

/**
 *
 * @author: WeFon
 * @date: 2018-10-29 20:55
 * @Copyright: 2018
 */
public class PepperoniPizza extends Pizza {
		PizzaIngredientFactory ingredientFactory;

		public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
				this.ingredientFactory = ingredientFactory;
		}

		@Override
		void prepare() {
				System.out.println("Preparing " + name);
				dough = ingredientFactory.createDough();
				sauce = ingredientFactory.createSauce();
				veggies = ingredientFactory.createVeggie();
				cheese = ingredientFactory.createCheese();
		}
}
