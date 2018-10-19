package com.learn.classloader;

/**
 * @ClassName: UcInfoEnterpriseExample
 * @Description:TODO
 * @author: 亚信安全NSG WeFon
 * @date: 2018/7/12
 * @Copyright: 2018
 */
public class Test01 {

	public static void main(String[] args)  throws Exception{
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		// 主动使用系统类加载器 加载类，并不会初始化这个类
		Class<?> clazz = classLoader.loadClass("com.learn.classloader.Cl");

		System.out.println("----------------");
		Class<?> cla =  Class.forName("com.learn.classloader.Cl");
	}
}
class Cl{
	static {
		System.out.println("CL");
	}
}
