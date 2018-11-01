package com.learn.designpatterners.command;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-31 23:19
 * @Copyright: 2018
 */
public class CeilingFan {
		String name;

		public CeilingFan(String name) {
				this.name = name;
		}

		public void on(){
				System.out.println("CeilingFan is On");
		}

		public void off(){
				System.out.println("CeilingFan is Off");
		}
}
