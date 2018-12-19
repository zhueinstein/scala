package com.learn.designpatterners.proxy;

import java.io.*;

/**
 *
 * @author: WeFon
 * @date: 2018-10-30 13:46
 * @Copyright: 2018
 */
public interface State extends Serializable {
		public void insertQuarter();
		public void ejectQuarter();
		public void turnCrank();
		public void dispense();

}
