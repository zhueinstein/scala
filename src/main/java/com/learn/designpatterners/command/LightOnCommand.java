package com.learn.designpatterners.command;

/**
 *
 * @author: WeFon
 * @date: 2018-10-31 22:32
 * @Copyright: 2018
 */
public class LightOnCommand implements Command {
		Light light;

		public LightOnCommand(Light light) {
				this.light = light;
		}

		@Override
		public void execute() {
				light.on();
		}
}
