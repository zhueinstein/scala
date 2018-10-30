package com.learn.designpatterners.factory.pizza;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-29 21:44
 * @Copyright: 2018
 */
public class NyPizzaIngredientFactory implements PizzaIngredientFactory{


		@Override
		public Dough createDough() {
				return new ThinCrustDough();
		}

		@Override
		public Sauce createSauce() {
				return new MarinaoSauce();
		}

		@Override
		public Cheese createCheese() {
				return new ReggianoCheese();
		}

		@Override
		public Veggie[] createVeggie() {
				Veggie[] veggies = {new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
				return veggies;
		}

		@Override
		public Pepperoni createPepperoni() {
				return new SlicedPepperoni();
		}

		@Override
		public Clams createClams() {
				return new FreshClams();
		}
}
