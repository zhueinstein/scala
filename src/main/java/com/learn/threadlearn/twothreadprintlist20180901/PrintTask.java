package com.learn.threadlearn.twothreadprintlist20180901;

import com.google.common.collect.Lists;

import java.util.List;

/**
 *
 * @author: WeFon
 * @date: 2018-09-01 00:40
 * @Copyright: 2018
 */
public class PrintTask {

		private Integer index;
		private  List<Integer> list = Lists.newArrayList();

		private PrintTask(List<Integer> list, int index) {
				this.list = list;
				this.index = index;
		}




}
