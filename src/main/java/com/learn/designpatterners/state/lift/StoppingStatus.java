package com.learn.designpatterners.state.lift;

/**
 * @author: veeFoo
 * @date: 2018-12-03 14:45
 * @Copyright: 2018
 */
public class StoppingStatus extends LiftState{
		@Override
		public void open() {
				super.context.setLiftState(Context.OPENING_STATUS);
				super.context.getLiftState().open();
		}

		@Override
		public void close() {
				super.context.setLiftState(Context.CLOSING_STATUS);
				super.context.getLiftState().close();
		}

		@Override
		public void run() {
				super.context.setLiftState(Context.RUNNING_STATUS);
				super.context.getLiftState().run();
		}

		@Override
		public void stop() {
				System.out.println("电梯停止……");
		}
}
