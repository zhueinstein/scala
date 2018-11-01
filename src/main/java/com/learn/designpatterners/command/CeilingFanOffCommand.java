package com.learn.designpatterners.command;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-31 23:20
 * @Copyright: 2018
 */
public class CeilingFanOffCommand implements Command{
		CeilingFan ceilingFan;

		public CeilingFanOffCommand(CeilingFan ceilingFan) {
				this.ceilingFan = ceilingFan;
		}

		@Override
		public void execute() {
			ceilingFan.off();
		}
}
