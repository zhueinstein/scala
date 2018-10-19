package com.learn.threadlearn.volatiles.volatile20180814;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-08-14 22:36
 * @Copyright: 2018
 */
public class Run {
		public static void main(String[] args) {
				List<VolatileDemo20180814> volatileDemos = Lists.newArrayList();
				for(int i = 0; i < 100; i++){
						volatileDemos.add(new VolatileDemo20180814());
				}

				for (VolatileDemo20180814 volatileDemo : volatileDemos) {
						volatileDemo.start();
				}

		}
}
