package com.learn.generictype;

import scala.Int;

/**
 * 创建者： ZhuWeiFeng
 * 日期： 2018/1/4
 */
public class Demo {
	// Person类被擦除泛型之后变为
	/**
		 public class Person {
		 private Object firstName;
		 private Object secondName;
		 public Person(Object firstName,Object secondName){
		 this.firstName=firstName;
		 this.secondName=secondName;
		 }
		 public Object getFirstName() {
		 return firstName;
		 }
		 public void setFirstName(Object firstName) {
		 this.firstName = firstName;
		 }
		 public Object getSecondName() {
		 return secondName;
		 }
		 public void setSecondName(Object secondName) {
		 this.secondName = secondName;
		 }

		 }
	 */

	public static void main(String[] args) {
		Person<String> p1 = new Person<>("WeFon", "29");
		Person<Integer> p2 = new Person<>(11,22);
		System.out.println(p1.getClass() == p2.getClass());
	}
}
