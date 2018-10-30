package com.learn.designpatterners.factory.pizza;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-29 20:55
 * @Copyright: 2018
 */
public class VeggiePizza extends Pizza {
		PizzaIngredientFactory ingredientFactory;

		public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
				this.ingredientFactory = ingredientFactory;
		}

		@Override
		void prepare() {
				System.out.println("Preparing " + name);
				dough = ingredientFactory.createDough();
				sauce = ingredientFactory.createSauce();
				clams = ingredientFactory.createClams();
				cheese = ingredientFactory.createCheese();
		}
}
