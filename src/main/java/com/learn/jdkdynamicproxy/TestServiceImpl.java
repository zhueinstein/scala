package com.learn.jdkdynamicproxy;

/**
 * @author： ZhuWeiFeng
 * @date： 2018/4/8
 */
public class TestServiceImpl implements TestService{
	private String name;

	public TestServiceImpl(String name) {
		this.name = name;
	}

	public TestServiceImpl() {
	}

	@Override
	public void say() {
		System.out.println(name);
	}
}
