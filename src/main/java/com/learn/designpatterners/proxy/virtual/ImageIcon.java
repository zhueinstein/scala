package com.learn.designpatterners.proxy.virtual;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-30 22:12
 * @Copyright: 2018
 */
public class ImageIcon implements Icon {

		public ImageIcon() {
		}

		public ImageIcon(URL imageUrl, String s) {
		}

		@Override
		public void paintIcon(Component c, Graphics g, int x, int y) {

		}

		@Override
		public int getIconWidth() {
				return 0;
		}

		@Override
		public int getIconHeight() {
				return 0;
		}
}
