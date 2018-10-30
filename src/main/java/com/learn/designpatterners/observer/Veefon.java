package com.learn.designpatterners.observer;

import com.learn.designpatterners.observer.mydesign.FonObserver;
import com.learn.designpatterners.observer.mydesign.FonPerson;

/**
 * @Description: 测试类
 * @author: WeFon
 * @date: 2018-10-26 13:55
 * @Copyright: 2018
 */
public class Veefon {

		public static void main(String[] args) {
				Person person = new Person();
				// 注册观察者
				MyObserver myObserver = new MyObserver();
				person.addObserver(myObserver);
				person.addObserver(new MyObserver2());
				person.setName("Veefon");
				person.setAge(22);

				// 自定义的观察者类
				FonPerson fonPerson = new FonPerson();
				FonObserver fonObserver = new FonObserver();
				fonPerson.addObserver(fonObserver);
				fonPerson.setName("自定义");
		}
}
