package com.learn.designpatterners.command;

/**
 *
 * @author: WeFon
 * @date: 2018-10-31 23:14
 * @Copyright: 2018
 */
public class Stereo {
		String name;

		public Stereo(String name) {
				this.name = name;
		}

		public void off(){
				System.out.println("Stereo Off");
		}

		public void on(){
				System.out.println("Stereo On");
		}
		public void setCD(){
				System.out.println("Stereo setCD OK");
		}

		public void setVolume(int volume){
				System.out.println("Stereo volume is " + volume);
		}
}
