package com.learn.designpatterners.observer.mydesign;

/**
 * @Description: 使用自定义的观察者
 * @author: WeFon
 * @date: 2018-10-26 15:14
 * @Copyright: 2018
 */
public class FonObserver implements VeeObserver {
		@Override
		public void update() {
				System.out.println("自定义的观察者模式生效了");
		}
}
