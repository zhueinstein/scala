package com.learn.designpatterners.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author: WeFon
 * @date: 2018-10-30 23:30
 * @Copyright: 2018
 */
public class OwnerInvocationHandler implements InvocationHandler {
		PersonBean personBean;

		public OwnerInvocationHandler(PersonBean personBean) {
				this.personBean = personBean;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				try {
						if (method.getName().startsWith("get")) {
								return method.invoke(personBean, args);
						} else if (method.getName().equals("setHotOrNotRating")) {
								throw new IllegalAccessException();
						} else if (method.getName().startsWith("set")) {
								return method.invoke(personBean, args);
						}
				} catch (InvocationTargetException ex) {
						ex.printStackTrace();
				}
				return null;
		}
}
