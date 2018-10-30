package com.learn.designpatterners.decorate;

/**
 * @Description: 测试类
 * @author: WeFon
 * @date: 2018-10-26 17:16
 * @Copyright: 2018
 */
public class Veefon {

		public static void main(String[] args) {
				// 手抓饼
				TornCake tornCake = new TornCake();
				System.out.println(tornCake.price());

				// 肉夹馍 + 牛肉 + 煎蛋

				OriginalCake rouJiaCake = new RouJiaCake();
				rouJiaCake = new CandidateBeef(rouJiaCake);
				rouJiaCake = new CandidateFiredEgg(rouJiaCake);
				System.out.println(rouJiaCake.getDescription());
				System.out.println(rouJiaCake.price());

		}
}
