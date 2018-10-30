package com.learn.designpatterners.observer;

import java.util.Observable;

/**
 * @Description: 被观察者
 * @author: WeFon
 * @date: 2018-10-26 13:49
 * @Copyright: 2018
 */
public class Person extends Observable {
		private String name;
		private String sex;
		private int age;

		public String getName() {
				return name;
		}

		public void setName(String name) {
				this.name = name;
				this.setChanged();
				// 当名称发生改变时， 通知观察者
				this.notifyObservers();
		}

		public String getSex() {
				return sex;
		}

		public void setSex(String sex) {
				this.sex = sex;
				this.setChanged();
				// 当名称发生改变时， 通知观察者
				this.notifyObservers();
		}

		public int getAge() {
				return age;
		}

		public void setAge(int age) {
				this.age = age;
				this.setChanged();
				// 当名称发生改变时， 通知观察者
				this.notifyObservers();
		}
}
