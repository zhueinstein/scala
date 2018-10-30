package com.learn.designpatterners.decorate;

/**
 * @Description: 肉夹馍，要被装饰的对象
 * @author: WeFon
 * @date: 2018-10-26 17:06
 * @Copyright: 2018
 */
public class RouJiaCake extends OriginalCake {
		public RouJiaCake() {
				description = "肉夹馍";
		}

		@Override
		public double price() {
				return 6;
		}
}
