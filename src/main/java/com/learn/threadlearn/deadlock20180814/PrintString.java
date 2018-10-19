package com.learn.threadlearn.deadlock20180814;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-08-14 18:55
 * @Copyright: 2018
 */
public class PrintString {

		public volatile boolean isContinue = true;

		public void setContinue(boolean aContinue) {
				isContinue = aContinue;
		}

		public void run(){
				System.out.println("进入到Run了");
				while (isContinue) {
						System.out.println("I'm print something ……");
				}
				System.out.println("结束Run了");
		}

		public static void main(String[] args) throws InterruptedException {
				PrintString printString = new PrintString();
				ExecutorService executorService = Executors.newSingleThreadExecutor();
				executorService.execute(() -> printString.run());
				Thread.sleep(1);
				printString.setContinue(false);
				System.out.println("已经把isContinue 设置为" + printString.isContinue);
		}
}
