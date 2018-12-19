package com.learn.designpatterners.proxy.virtual;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 *
 * @author: WeFon
 * @date: 2018-10-30 22:11
 * @Copyright: 2018
 */
public class ImageProxy implements Icon {
		ImageIcon imageIcon;
		URL imageUrl;
		Thread retrievingThread;
		Boolean retrieving = false;

		public ImageProxy(URL url) {
				this.imageUrl = url;
		}

		@Override
		public void paintIcon(Component c, Graphics g, int x, int y) {
				if(imageIcon != null){
						imageIcon.paintIcon(c, g, x, y);
				}else{
						g.drawString("Loading CD cover, please waiting", x + 300, y + 300);
						if(!retrieving){
								retrieving = true;
								retrievingThread = new Thread(() ->{
										imageIcon = new ImageIcon(imageUrl, "CD cover");
										c.repaint();
								});
								retrievingThread.start();
						}
				}
		}

		@Override
		public int getIconWidth() {
				if(imageIcon != null){
						return imageIcon.getIconWidth();
				}else {
						return 800;
				}
		}

		@Override
		public int getIconHeight() {
				if(imageIcon != null){
						return imageIcon.getIconHeight();
				}else{
						return 600;
				}
		}
}
