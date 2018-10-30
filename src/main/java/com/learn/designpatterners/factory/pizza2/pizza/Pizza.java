package com.learn.designpatterners.factory.pizza2.pizza;

import java.util.ArrayList;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-29 20:53
 * @Copyright: 2018
 */
public abstract class Pizza {
		String name;
		String dough;
		String sauce;
		ArrayList toppings = new ArrayList();

		void prepare() {
				System.out.println("开始准备做披萨" + name);
				System.out.println("Tossing doughing");
				System.out.println("Adding sauce");
				System.out.println("Adding toppings");
				for (Object topping : toppings) {
						System.out.println(" " + topping);
				}
		}

		void bake() {
				System.out.println("准备完毕，bake披萨" );
		}

		void cut() {
				System.out.println("bake披萨完毕，切块");
		}

		void box() {
				System.out.println("切块完毕，装箱");
		}

		public String getName() {
				return name;
		}
}
