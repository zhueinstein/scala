package com.learn.designpatterners.factory.pizza2.pizza;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-29 21:07
 * @Copyright: 2018
 */
public class NyStyleCheesePizza extends Pizza {

		public NyStyleCheesePizza() {
				name = "NY Style sauce and Cheese Pizza";
				dough = "Thin Crust Dough";
				sauce = "Marinara Sauce";

				toppings.add("Grated Reggiano Cheese");
		}
}
