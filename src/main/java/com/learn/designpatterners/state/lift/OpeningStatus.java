package com.learn.designpatterners.state.lift;

/**
 * @author: WeFon
 * @date: 2018-12-03 14:31
 * @Copyright: 2018
 */
public class OpeningStatus extends LiftState {

		@Override
		public void close() {
				super.context.setLiftState(Context.CLOSING_STATUS);
				super.context.getLiftState().close();
		}


		@Override
		public void open() {
				System.out.println("电梯门开启……");
		}

		@Override
		public void run() {
			// do nothing
		}

		@Override
		public void stop() {
				// do nothing
		}

}
