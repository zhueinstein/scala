package com.learn.Invocation;

/**
 * @author： ZhuWeiFeng
 * @data： 2018/3/20
 */
public class UserServiceImpl implements UserService{
	@Override
	public String getName(int id) {
		System.out.println("------getName------");
		return "Tom";
	}

	@Override
	public Integer getAge(int id) {
		System.out.println("------getAge------");
		return 10;
	}
}
