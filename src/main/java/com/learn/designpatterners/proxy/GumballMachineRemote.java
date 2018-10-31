package com.learn.designpatterners.proxy;

import java.rmi.*;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-30 13:44
 * @Copyright: 2018
 */
public interface GumballMachineRemote extends Remote {
		public int getCount() throws RemoteException;
		public String getLocation() throws RemoteException;
		public State getState() throws RemoteException;
}
