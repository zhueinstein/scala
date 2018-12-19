package com.learn.designpatterners.state.lift;

/**
 * @author: veeFoo
 * @date: 2018-12-03 14:45
 * @Copyright: 2018
 */
public class ClosingStatus extends LiftState{
		@Override
		public void open() {
				super.context.setLiftState(Context.OPENING_STATUS);
				//
				super.context.getLiftState().open();
		}

		@Override
		public void close() {
				System.out.println("电梯门关闭……");
		}

		@Override
		public void run() {
			super.context.setLiftState(Context.RUNNING_STATUS);
			super.context.getLiftState().run();
		}

		@Override
		public void stop() {
			// do nothing
		}
}
