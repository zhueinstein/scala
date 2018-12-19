package com.learn.designpatterners.proxy;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author: WeFon
 * @date: 2018-10-30 12:39
 * @Copyright: 2018
 */
public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote{

		String location;
		int count;
		State state;

		public GumballMachine(String location, int count, State state) throws RemoteException{
				this.location = location;
				this.count = count;
				this.state = state;
		}

		public GumballMachine(String location, int count) throws RemoteException{
				this.location = location;
				this.count = count;
		}



		public void setLocation(String location) {
				this.location = location;
		}


		public void setCount(int count) {
				this.count = count;
		}


		public void setState(State state) {
				this.state = state;
		}

		@Override
		public int getCount() {
				return count;
		}

		@Override
		public String getLocation(){
				return location;
		}

		@Override
		public State getState()  {
				return state;
		}
}
