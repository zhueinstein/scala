package com.learn.designpatterners.adapter;

/**
 *
 * @author: WeFon
 * @date: 2018-11-01 21:27
 * @Copyright: 2018
 */
public class TukeyImpl implements Turkey {
		@Override
		public void fly() {
				System.out.println(" FLy Fly");
		}

		@Override
		public void globby() {
				System.out.println("Globby ");
		}
}
