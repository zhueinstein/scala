package com.learn.designpatterners.command;

/**
 *
 * @author: WeFon
 * @date: 2018-10-31 22:41
 * @Copyright: 2018
 */
public class GarageDoor {
		String name;

		public GarageDoor(String name) {
				this.name = name;
		}

		public void up(){
				System.out.println("GarageDoor UP");
		}
		public void down(){
				System.out.println("GarageDoor DOWN");
		}
		public void stop(){
				System.out.println("GarageDoor STOP");
		}
		public void lightOn(){
				System.out.println("GarageDoor LightOn");
		}
		public void lightOff(){
				System.out.println("GarageDoor LightOff");
		}

}
