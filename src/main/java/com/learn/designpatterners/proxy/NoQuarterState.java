package com.learn.designpatterners.proxy;

/**
 *
 * @author: WeFon
 * @date: 2018-10-30 14:14
 * @Copyright: 2018
 */
public class NoQuarterState implements State {
		transient GumballMachine gumballMachine;

		@Override
		public void insertQuarter() {

		}

		@Override
		public void ejectQuarter() {

		}

		@Override
		public void turnCrank() {

		}

		@Override
		public void dispense() {

		}
}
