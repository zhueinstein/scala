package com.learn.threadlearn.rpt;

/**
 * @author： ZhuWeiFeng
 * @date： 2018/4/5
 */
public class ReferParamTransThread extends Thread{
	@Override
	public void run() {
		ReferParamTransTest rt = new ReferParamTransTest();
		rt.referParamTransRun(User.getUser());
	}
}
