package com.learn.memery;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-08-14 09:30
 * @Copyright: 2018
 */
public class ReOrderTest20180814 {
		int a = 0;
		boolean flag = false;
		public void writter(){
				a = 1;
				flag = true;
		}
		public void reader(){
				if(flag){
					System.out.println(String.format("reader 中 a = %s", a));
				}
		}

		public static void main(String[] args) {
				ExecutorService executorService = Executors.newCachedThreadPool();
				for (int i = 0; i < 2000; i++) {
						ReOrderTest20180814 reOrder = new ReOrderTest20180814();
						executorService.execute(() -> reOrder.writter());
						executorService.execute(() -> reOrder.reader());
				}
		}
}
