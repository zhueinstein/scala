package com.learn.designpatterners.proxy.virtual;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-30 22:22
 * @Copyright: 2018
 */
public class ImageProxyTestDrive {
		ImageComponent imageComponent;
		JFrame frame = new JFrame("CD Cover");
		JMenuBar menuBar;
		JMenu menu;
		Hashtable<String, String> cds = new Hashtable();

 		public static void main(String[] args) throws Exception {
				ImageProxyTestDrive testDrive = new ImageProxyTestDrive();
		}

		public ImageProxyTestDrive() throws Exception {
				cds.put("迷彩", "http://phg1c0cv0.bkt.clouddn.com/0L3A5217.JPG");
				cds.put("下棋", "http://phg1c0cv0.bkt.clouddn.com/0L3A5304.JPG");
				URL  initUrl = new URL(cds.get("迷彩"));
				menuBar = new JMenuBar();
				menu = new JMenu("Favourite Cd");
				menuBar.add(menu);
				frame.setJMenuBar(menuBar);

				for(Enumeration e = cds.keys(); e.hasMoreElements();){
						String name = (String) e.nextElement();
						JMenuItem menuItem = new JMenuItem(name);
						menu.add(menuItem);
						menuItem.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
										imageComponent.setIcon(new ImageProxy(getCdUrl(e.getActionCommand())));
										frame.repaint();
								}
						});
				}
				// 建立框架和菜单
				Icon icon = new ImageProxy(initUrl);
				imageComponent = new ImageComponent(icon);
				frame.getContentPane().add(imageComponent);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(1500, 1000);
				frame.setVisible(true);
		}

		private URL getCdUrl(String actionCommand) {
				try {
						return new URL(cds.get(actionCommand));
				} catch (MalformedURLException e) {
						e.printStackTrace();
				}
				return null;
		}
}
