package com.learn.variance;

import com.learn.beginnerForScala.generic.Num;

import java.util.ArrayList;

/**
 *  https://www.cnblogs.com/en-heng/p/5041124.html
 * 创建者： ZhuWeiFeng
 * 日期：2017/12/20
 *  Java中的协变与逆变
 *   里氏替换原则（LSP）
 *   所有使用父类的地方都必须可以透明的使用其子类的对象
 *      里氏替换有四层含义：
 *              1、子类完全拥有父类的方法，且具体子类实现父类的抽象方法
 *              2、z子类可以增加自己的方法
 *              3、当子类覆盖或则实现父类的方法时，方法的形参要比父类的方法更为宽松
 *              4、当子类覆盖活着实现父类的方法时，方法的返回值要比父类更严格
 */
public class VarianceDemo {
	public static void main(String[] args) {
		Number number = new Integer(1);
		//ArrayList<Number> numberList = new ArrayList<Integer>(); // 出错， 类型不匹配

//		ArrayList<? extends Number> list = new ArrayList<>();
//		list.add(new Integer(1));
//		list.add(new Float(1.2));


	}
}
