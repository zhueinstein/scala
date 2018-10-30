package com.learn.designpatterners.factory.pizza2.pizza;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-29 21:09
 * @Copyright: 2018
 */
public class ChicagoStyleCheesePizza extends Pizza {

		public ChicagoStyleCheesePizza() {
				name = "Chicago Style sauce and Cheese Pizza";
				dough = "Extra Thin Crust Dough";
				sauce = "Marinara Sauce";

				toppings.add("Shredded Mozzarella Cheese");
		}

		@Override
		void cut() {
				System.out.println("Cutting the pizza into square slices");
		}
}
