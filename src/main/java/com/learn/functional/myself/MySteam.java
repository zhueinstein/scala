package com.learn.functional.myself;

import java.util.List;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-11-20 16:59
 * @Copyright: 2018
 */
public class MySteam<T> {
		private List<T> list;

		public List<T> getList() {
				return list;
		}

		public void setList(List<T> list) {
				this.list = list;
		}

		public void show(ConsumerInterface<T> consumerInterface){
				list.forEach(ds -> consumerInterface.accept(ds));
		}
}
