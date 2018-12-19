package com.learn.designpatterners.proxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 *
 * @author: WeFon
 * @date: 2018-10-30 12:38
 * @Copyright: 2018
 */
public class GumballMachineTest {

		public static void main(String[] args) throws RemoteException, MalformedURLException {
				int count = 0;

				if(args.length < 2){
						System.out.println("Gumball Machine <name> <inventory>");
						System.exit(1);
				}
				count = Integer.valueOf(args[1]);
				GumballMachine gumballMachine = new GumballMachine(args[0], count);
				Naming.rebind("rmi://" + args[0] + "/gumballmachine", gumballMachine);
				GumBallMonitor monitor = new GumBallMonitor(gumballMachine);

				monitor.report();
		}
}
