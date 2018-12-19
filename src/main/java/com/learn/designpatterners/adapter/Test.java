package com.learn.designpatterners.adapter;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author: WeFon
 * @date: 2018-11-01 21:29
 * @Copyright: 2018
 */
public class Test {

		public static void main(String[] args) {
				Turkey turkey = new TukeyImpl();

				DuckAdapter duckAdapter = new DuckAdapter(turkey);
				duckAdapter.fly();
				duckAdapter.quack();

				Vector<String> vector = new Vector<>();
				vector.add("1");
				vector.add("12");
				vector.add("123");
				Enumeration<String> elements = vector.elements();
				EnumerationIterator enumerationIterator = new EnumerationIterator(elements);
				while(enumerationIterator.hasNext()){
						Object s = enumerationIterator.next();
						System.out.println(s);
				}
				while(elements.hasMoreElements()){
						Object s = elements.nextElement();
						System.out.println(s);
				}

				ArrayList arrayList = new ArrayList();
				arrayList.add("SS");
				arrayList.add("SSe");
				arrayList.add("SSr");
				arrayList.add("SSt");
				arrayList.add("SSv");
				arrayList.add("SSb");
				ArrayListAdapter arrayListAdapter = new ArrayListAdapter(arrayList);
				while(arrayListAdapter.hasNext()){
						Object next = arrayListAdapter.next();
						System.out.println(next);
				}
		}
}
