package com.learn.designpatterners.command;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-31 23:15
 * @Copyright: 2018
 */
public class StereoOnWithCDCommand implements Command {
		Stereo stereo;

		public StereoOnWithCDCommand(Stereo stereo) {
				this.stereo = stereo;
		}

		@Override
		public void execute() {
				stereo.on();
				stereo.setCD();
				stereo.setVolume(11);
		}
}
