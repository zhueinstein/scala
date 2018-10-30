package com.learn.designpatterners.observer.mydesign;

/**
 * @Description: 被观察者 decorator
 * @author: WeFon
 * @date: 2018-10-26 15:13
 * @Copyright: 2018
 */
public class FonPerson extends VeeObserable {
		private String name;

		public String getName() {
				return name;
		}

		public void setName(String name) {
				this.name = name;
				this.setChanged();
				this.noticeAll();
		}
}
