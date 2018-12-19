package com.learn.designpatterners.adapter;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @Description: 使用Iterator包装Enumeration对象
 * @author: WeFon
 * @date: 2018-11-01 21:57
 * @Copyright: 2018
 */
public class EnumerationIterator implements Iterator {
		Enumeration enumeration;

		public EnumerationIterator(Enumeration enumeration) {
				this.enumeration = enumeration;
		}

		@Override
		public Object next() {
				return enumeration.nextElement();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean hasNext() {
				return enumeration.hasMoreElements();
		}

		@Override
		public void forEachRemaining(Consumer action) {

		}
}
