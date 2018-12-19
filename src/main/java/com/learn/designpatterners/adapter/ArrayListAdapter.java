package com.learn.designpatterners.adapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 * @author: WeFon
 * @date: 2018-11-01 22:05
 * @Copyright: 2018
 */
public class ArrayListAdapter implements Iterator {
		ArrayList arrayList;
		public ArrayListAdapter(ArrayList arrayList) {
				this.arrayList = arrayList;
		}

		@Override
		public boolean hasNext() {
				System.out.println(arrayList.isEmpty());
				return !arrayList.isEmpty();
		}

		@Override
		public Object next() {
				remove();
				return arrayList.get(0);
		}

		@Override
		public void remove() {
				if(arrayList.size() != 1) {
						arrayList.remove(0);
				}
		}

		@Override
		public void forEachRemaining(Consumer action) {

		}
}
