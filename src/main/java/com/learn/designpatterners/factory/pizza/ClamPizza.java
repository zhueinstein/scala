package com.learn.designpatterners.factory.pizza;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-29 20:55
 * @Copyright: 2018
 */
public class ClamPizza extends Pizza {
		PizzaIngredientFactory ingredientFactory;

		public ClamPizza(PizzaIngredientFactory ingredientFactory) {
				this.ingredientFactory = ingredientFactory;
		}

		@Override
		void prepare() {
				System.out.println("Preparing " + name);
				dough = ingredientFactory.createDough();
				sauce = ingredientFactory.createSauce();
				cheese = ingredientFactory.createCheese();
				clams = ingredientFactory.createClams();
		}
}
