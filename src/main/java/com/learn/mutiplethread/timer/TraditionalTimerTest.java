package com.learn.mutiplethread.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName: UcInfoEnterpriseExample
 *
 * @author: 亚信安全NSG WeFon
 * @date: 2018/7/16
 * @Copyright: 2018
 */
public class TraditionalTimerTest {

	private static int count = 0;

	public static void main(String[] args) {
		class MyTimerTask extends TimerTask {
			@Override
			public void run() {
				count = (count + 1) %2;
				System.out.println("Bombing!");
				new Timer().schedule(new MyTimerTask(), 2000 + 2000* count);
			}
		}
		new Timer().schedule(new MyTimerTask(), 5000);

	}

}

