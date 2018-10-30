package com.learn.designpatterners.factory.pizza;

import java.util.ArrayList;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-29 20:53
 * @Copyright: 2018
 */
public abstract class Pizza {
		String name;
		Dough dough;
		Sauce sauce;
		Veggie[] veggies;
		Cheese cheese;
		Pepperoni pepperoni;
		Clams clams;

		abstract void prepare();

		void bake() {
				System.out.println("Bake for 25 minutes at 350" );
		}

		void cut() {
				System.out.println("Cutting the pizza into diagonal slices");
		}

		void box() {
				System.out.println("Place pizza in official PizzaStore box");
		}

		public String getName() {
				return name;
		}

		public void setName(String name) {
				this.name = name;
		}
}
