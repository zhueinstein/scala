package com.learn.threadlearn.rpt;

/**
 * @author： ZhuWeiFeng
 * @date： 2018/4/5
 */
public class ReferParamTransTest {

	public void referParamTransRun(User user){
		for(int i = 0; i <= 10; i++){
			synchronized (user) {
				String newName = "name" + Thread.currentThread().getId();
				user.setName(newName);
				try {
					Thread.sleep(50 * i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (newName.equals(user.getName())) {
					System.out.println("[" + Thread.currentThread().getId() + "]当name=" + newName + "获取name 的值:" + user.getName());
				} else {
					System.err.println("[" + Thread.currentThread().getId() + "]当name=" + newName + "获取name 的值:" + user.getName());
				}
			}
		}
	}

}
