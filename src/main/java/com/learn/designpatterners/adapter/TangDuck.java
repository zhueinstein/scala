package com.learn.designpatterners.adapter;

/**
 *
 * @author: WeFon
 * @date: 2018-11-01 21:25
 * @Copyright: 2018
 */
public class TangDuck implements Duck {
		@Override
		public void fly() {
				System.out.println("I'm Flying");
		}

		@Override
		public void quack() {
				System.out.println("quack quack quack");
		}
}
