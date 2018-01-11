package com.learn.study.javascalaoperating;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者： ZhuWeiFeng
 * 日期： 2018/1/5
 */
public class JavaWildcardGeneric {

	public static List<?> getList(){
		// Java中的通配符？，可以接收任何类的List
		List<String> list = new ArrayList<>();
		list.add("Java");
		list.add("Scala");
		list.add("Spark");
		return list;
	}
}
