package com.learn.study.javascalaoperating;

/**
 * 创建者： ZhuWeiFeng
 * 日期： 2018/1/5
 */

import scala.collection.immutable.List;

/**
 * 1、Java中调用Scala
 *             Java可以直接操作纵Scala类，如同Scala直接使用Java中的类一样，例如：
 */

public class JavaDemo {
	public static void main(String[] args) {
		ScalaDemo.scalaMethod(3);

		Student<String, Integer> s1 = new Student<>("S1", 1);
		System.out.println(s1.name());

	}
}
//java直接implement，与普通的java接口一样
class MySqlDaoImpl implements MySQLDAO{
	@Override
	public boolean delete(String id) {
		return false;
	}

	@Override
	public boolean add(Object o) {
		return false;
	}

	@Override
	public int update(Object o) {
		return 0;
	}

	@Override
	public List<Object> query(String id) {
		return null;
	}
}

class MySqlDaoImpl1 implements MySQLDAO1{
	@Override
	public boolean delete(String id) {
		//调用生成带有具体delete方法实现的MySQLDAO$class
		if(MySQLDAO1$class.delete(this, id)){ return true;}else {
			return false;
		}

	}

	@Override
	public boolean add(Object o) {
		return false;
	}

	@Override
	public int update(Object o) {
		return 0;
	}

	@Override
	public List<Object> query(String id) {
		return null;
	}
}