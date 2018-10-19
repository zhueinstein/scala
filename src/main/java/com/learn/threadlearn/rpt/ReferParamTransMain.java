package com.learn.threadlearn.rpt;

/**
 * @author： ZhuWeiFeng
 * @date： 2018/4/5
 * 这个例子中的user对象虽然从头到尾都是被当作参数在方法中传递，但是由于User对象是单例的，
 * 所以多线程的情况下不同线程中方法中传递的user对象都是同一个实例对象（共享资源）。
 * 同时，由于java中的非基本数据类型(注1)对象参数传递采用的是“引用传递”，而不是 “值传递”，
 * 所以一个线程在接受到user实例对象的referParamTransRun()方法中队user实例对象做了修改，
 * 对其它的线程是可见的。这样就会出现下面的场景：当线程11给user对象的name属性赋值为name12之后，
 * 进入睡眠状态，这个时候线程12将ser实例对象的name属性修改为name12，
 * 当name11醒来的时候继续执行下面的代码用到的user对象就不是自己想象的了，而是被线程12篡改过的。这样就导致了线程不安全问题。
 */
public class ReferParamTransMain {

	public static void main(String[] args) {
		for(int i=0; i<10; i++){
			ReferParamTransThread t = new ReferParamTransThread();
			t.start();
		}
	}
}
