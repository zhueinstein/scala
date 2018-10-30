package com.learn.designpatterners.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Description: 观察者， 通知观察的对象
 * @author: WeFon
 * @date: 2018-10-26 13:53
 * @Copyright: 2018
 */
public class MyObserver2 implements Observer {

		@Override
		public void update(Observable o, Object arg) {
				System.out.println("对象发生变化2");
		}
}
