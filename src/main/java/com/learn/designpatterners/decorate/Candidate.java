package com.learn.designpatterners.decorate;

/**
 * @Description: 装饰的小对象抽象
 * @author: WeFon
 * @date: 2018-10-26 17:08
 * @Copyright: 2018
 */
public abstract  class Candidate extends OriginalCake{

		/**
		 * 获取描述
		 * @return
		 */
		@Override
		public abstract String getDescription();
}
