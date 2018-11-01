package com.learn.designpatterners.command;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-31 22:32
 * @Copyright: 2018
 */
public class Light {
		String name;

		public Light(String name) {
				this.name = name;
		}

		public void on() {
				System.out.println("Light is on");
		}
		public void off() {
				System.out.println("Light is off");
		}
}
