package com.learn.designpatterners.command;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-31 22:39
 * @Copyright: 2018
 */
public class GarageDoorCloseCommand implements Command {
		GarageDoor garageDoor;

		public GarageDoorCloseCommand(GarageDoor garageDoor) {
				this.garageDoor = garageDoor;
		}

		@Override
		public void execute() {
				garageDoor.down();
		}
}
