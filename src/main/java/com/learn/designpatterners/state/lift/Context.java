package com.learn.designpatterners.state.lift;

/**
 * @author: WeFon
 * @date: 2018-12-03 14:26
 * @Copyright: 2018
 */
public class Context {
		public static OpeningStatus OPENING_STATUS = new OpeningStatus();
		public static ClosingStatus CLOSING_STATUS = new ClosingStatus();
		public static RunningStatus RUNNING_STATUS = new RunningStatus();
		public static StoppingStatus STOPPING_STATUS = new StoppingStatus();

		/**
		 * 定义一个当前电梯的状态
		 */
		private LiftState liftState;

		public LiftState getLiftState() {
				return liftState;
		}

		public void setLiftState(LiftState liftState) {
				this.liftState = liftState;
				// 把当前的状态通知到各个具体实现类中
				this.liftState.setContext(this);
		}

		public void open(){
				this.liftState.open();
		}

		public void close(){
				this.liftState.close();
		}

		public void run(){
				this.liftState.run();
		}

		public void stop(){
				this.liftState.stop();
		}

}
