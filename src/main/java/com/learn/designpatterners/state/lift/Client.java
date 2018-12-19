package com.learn.designpatterners.state.lift;

/**
 * @author: veeFoo
 * @date: 2018-12-03 14:58
 * @Copyright: 2018
 */
public class Client {

		public static void main(String[] args) {
				Context context = new Context();
				context.setLiftState(Context.RUNNING_STATUS);
				context.run();
				context.close();
				context.open();
				context.stop();
		}
}
