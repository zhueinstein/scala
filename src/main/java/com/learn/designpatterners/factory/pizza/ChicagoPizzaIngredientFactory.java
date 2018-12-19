package com.learn.designpatterners.factory.pizza;

/**
 *
 * @author: WeFon
 * @date: 2018-10-29 21:44
 * @Copyright: 2018
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory{


		@Override
		public Dough createDough() {
				return new ThicKCrustDough();
		}

		@Override
		public Sauce createSauce() {
				return new PlumTomatoSauce();
		}

		@Override
		public Cheese createCheese() {
				return new ReggianoCheese();
		}

		@Override
		public Veggie[] createVeggie() {
				Veggie[] veggies = {new Spinach(), new BlackOlives(), new Mozzarella(), new EggPlant()};
				return veggies;
		}

		@Override
		public Pepperoni createPepperoni() {
				return new SlicedPepperoni();
		}

		@Override
		public Clams createClams() {
				return new FrozenClams();
		}
}
