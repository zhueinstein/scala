package com.learn.designpatterners.decorate;

/**
 * @Description: 手抓饼 要被装饰的对象
 * @author: WeFon
 * @date: 2018-10-26 17:01
 * @Copyright: 2018
 */
public class TornCake extends OriginalCake {
		public TornCake() {
				description = "手抓饼";
		}

		@Override
		public double price() {
			return 4;
		}
}
