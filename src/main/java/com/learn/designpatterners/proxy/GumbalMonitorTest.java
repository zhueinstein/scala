package com.learn.designpatterners.proxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author: WeFon
 * @date: 2018-10-30 12:38
 * @Copyright: 2018
 */
public class GumbalMonitorTest {
		//, "rmi://10.1.64.123/gumballmachine"
		public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
				String[] locations = {"rmi://10.1.65.179/gumballmachine"};
				GumBallMonitor[] gumBallMonitors = new GumBallMonitor[locations.length];
				for (int i = 0; i < locations.length; i ++) {
						GumballMachineRemote gumballMachine = (GumballMachineRemote) Naming.lookup(locations[i]);
						gumBallMonitors[i] = new GumBallMonitor(gumballMachine);
						System.out.println(gumBallMonitors[i]);
				}

				for (GumBallMonitor gumBallMonitor : gumBallMonitors) {
						gumBallMonitor.report();
				}
		}
}
