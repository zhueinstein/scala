package com.learn.designpatterners.proxy;

import java.rmi.RemoteException;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-30 12:40
 * @Copyright: 2018
 */
public class GumBallMonitor {

		GumballMachineRemote gumballMachine;

		public GumBallMonitor(GumballMachineRemote gumballMachine) {
				this.gumballMachine = gumballMachine;
		}

		public void report(){
				try {
						System.out.println("Gumball Machine: " + gumballMachine.getLocation());
						System.out.println("Current inventory: " + gumballMachine.getCount());
						System.out.println("Current state: " + gumballMachine.getState());
				}catch (RemoteException re){
						re.printStackTrace();
				}
		}
}
