package com.learn.designpatterners.state.lift;

/**
 * @author: WeFon
 * @date: 2018-12-03 14:25
 * @Copyright: 2018
 */
public abstract class LiftState {
		protected Context context;

		public void setContext(Context context) {
				this.context = context;
		}

		/**
		 * 首 先 电 梯 门 开 启 动 作
 		 */
		 public abstract void open();

		/**
		 *  电 梯 门 有 开 启， 那 当 然 也 就 有 关 闭 了
		 */
		 public abstract void close();
		/**
		 *  电 梯 要 能 上 能 下， 运 行 起 来
		 */
		 public abstract void run();
		/**
		 *  电 梯 还 要 能 停 下 来
		 */
		public abstract void stop();

}
