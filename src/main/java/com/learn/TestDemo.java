package com.learn;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/**
 * @author： ZhuWeiFeng
 * @data： 2018/3/19
 */
public class TestDemo {
	public static void main(String[] args) {
		HashMap hm = Maps.newHashMap();
		Object oldValue = hm.put("a", "11");
		Object oldValue2 = hm.put("a", "11");
		Object oldValue3 = hm.put("a", "11");
		Integer ww;
		if((ww = 11) == 11){
			System.out.println(11);
		}
		System.out.println(oldValue2 ==  oldValue3);
		String a = "222";
		String a1 = "222";
		System.out.println(TestDemo.hash(a));
		System.out.println(TestDemo.hash(a1));

		Demo d1 = new Demo();
		d1.setName("123");
		Demo d2 = new Demo();
		d2.setName("123");
		System.out.println(TestDemo.hash(d1));
		System.out.println(TestDemo.hash(d2));
		Set<String> set = Sets.newHashSet();
		set.add("Java");
		set.add("Scala");
		set.add("Spark");
		set = Collections.unmodifiableSet(set);
		/**
		 * 通过Collections的方法装饰之后，set变为不可变集合
		 */
//		set.add("Ajax");
		String key = "Java";
		int hashCode = key.hashCode();
		System.out.println(hashCode + " ==  "+ (hashCode ^ (hashCode >>> 16)));
	}
	final static int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}
}
class Demo{
	private String name;
	private  String mark;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	@Override
	public int hashCode() {
		return TestDemo.hash(name + "     " + mark);
	}
}