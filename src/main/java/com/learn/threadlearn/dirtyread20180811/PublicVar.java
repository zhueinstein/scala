package com.learn.threadlearn.dirtyread20180811;

/**
 * @ClassName: UcInfoEnterpriseExample
 * @Description:TODO
 * @author: 亚信安全NSG WeFon
 * @date: 2018/8/11
 * @Copyright: 2018
 */
public class PublicVar {
		public  String userName = "A";
		public String password = "AA";

		synchronized public void setVal(String userName, String password){
				this.userName = userName;
				try {
						Thread.sleep(5000);
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
				this.password = password;
				System.out.println("setVal method thread name = " + Thread.currentThread().getName() + "  username = " + userName + "  password = " + password);
		}

		public synchronized void getVal(){
				System.out.println("getVal method thread name = " + Thread.currentThread().getName() + "  username = " + userName + "  password = " + password);
		}

		public static void main(String[] args) throws InterruptedException {
				PublicVar publicVar = new PublicVar();

				new Thread(() -> publicVar.setVal("a", "nn")).start();
				publicVar.getVal();
		}
}
