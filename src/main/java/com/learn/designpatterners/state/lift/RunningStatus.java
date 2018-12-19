package com.learn.designpatterners.state.lift;

/**
 * @author: veeFoo
 * @date: 2018-12-03 14:45
 * @Copyright: 2018
 */
public class RunningStatus extends LiftState{
		@Override
		public void open() {
				// do nothing
		}

		@Override
		public void close() {
				// do nothing
		}

		@Override
		public void run() {
				System.out.println("电梯运行中……");
		}

		@Override
		public void stop() {
				super.context.setLiftState(Context.STOPPING_STATUS);
				super.context.getLiftState().stop();
		}
}
