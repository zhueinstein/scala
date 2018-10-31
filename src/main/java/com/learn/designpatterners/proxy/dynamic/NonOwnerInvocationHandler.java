package com.learn.designpatterners.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-30 23:30
 * @Copyright: 2018
 */
public class NonOwnerInvocationHandler implements InvocationHandler {
		PersonBean personBean;

		public NonOwnerInvocationHandler(PersonBean personBean) {
				this.personBean = personBean;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
				try {
						if (method.getName().startsWith("get")) {
								return method.invoke(personBean, args);
						} else if (method.getName().equals("setHotOrNotRating")) {
								return method.invoke(personBean, args);
						} else if (method.getName().startsWith("set")) {
								throw new IllegalAccessException();
						}
				} catch (InvocationTargetException ex) {
						ex.printStackTrace();
				}
				return null;
		}
}
