package com.learn.generictype;

/**
 * 创建者： ZhuWeiFeng
 * 日期： 2018/1/4
 *      类型擦除
 */
public class Person<T> {
	private T firstName;
	private T secondName;

	public Person(T firstName, T secondName) {
		this.firstName = firstName;
		this.secondName = secondName;
	}

	public T getFirstName() {
		return firstName;
	}

	public void setFirstName(T firstName) {
		this.firstName = firstName;
	}

	public T getSecondName() {
		return secondName;
	}

	public void setSecondName(T secondName) {
		this.secondName = secondName;
	}
}


