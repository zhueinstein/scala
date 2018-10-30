package com.learn.designpatterners.factory.simple;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-29 20:53
 * @Copyright: 2018
 */
public abstract class Pizza {

		void prepare() {
				System.out.println("开始准备做披萨");
		}

		void bake() {
				System.out.println("准备完毕，bake披萨");
		}

		void cut() {
				System.out.println("bake披萨完毕，切块");
		}

		void box() {
				System.out.println("切块完毕，装箱");
		}

}
