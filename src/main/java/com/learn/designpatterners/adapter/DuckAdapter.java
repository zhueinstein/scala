package com.learn.designpatterners.adapter;

/**
 *
 * @author: WeFon
 * @date: 2018-11-01 21:28
 * @Copyright: 2018
 */
public class DuckAdapter implements Duck{
		Turkey turkey;

		public DuckAdapter(Turkey turkey) {
				this.turkey = turkey;
		}

		@Override
		public void fly() {
				turkey.fly();
		}

		@Override
		public void quack() {
				turkey.globby();
		}
}
