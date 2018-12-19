package com.learn.designpatterners.command;

/**
 *
 * @author: WeFon
 * @date: 2018-10-31 23:15
 * @Copyright: 2018
 */
public class StereoOffWithCDCommand implements Command {
		Stereo stereo;

		public StereoOffWithCDCommand(Stereo stereo) {
				this.stereo = stereo;
		}

		@Override
		public void execute() {
				stereo.off();
		}
}
