package com.learn.designpatterners.command;

import java.util.Arrays;

/**
 *
 * @author: WeFon
 * @date: 2018-10-31 22:34
 * @Copyright: 2018
 */
public class RemoteControl {
		Command[] onCommands;
		Command[] offCommands;

		public RemoteControl() {
				onCommands = new Command[7];
				offCommands = new Command[7];
				Command noCommand = new NoCommand();
				for (int i = 0; i < 7; i++) {
						onCommands[i] = noCommand;
						offCommands[i] = noCommand;
				}
		}

		public void setCommand(int slot, Command onCommand, Command offCommand) {
				onCommands[slot] = onCommand;
				offCommands[slot] = offCommand;
		}

		public void onButtonWasPressed(int slot) {
				onCommands[slot].execute();
		}

		public void offButtonWaspressed(int slot) {
				offCommands[slot].execute();
		}

		@Override
		public String toString() {
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("\n-------------- Remote Control ----------------\n");
				for(int i = 0; i < 7; i ++){
						stringBuilder.append("[slot " + i +"]" + onCommands[i].getClass().getName() + "  " + offCommands[i].getClass().getName() + "\n");
				}
				return stringBuilder.toString();
		}
}
