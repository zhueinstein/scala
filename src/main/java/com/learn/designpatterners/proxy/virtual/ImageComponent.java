package com.learn.designpatterners.proxy.virtual;

import javax.swing.*;
import java.awt.*;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-31 10:16
 * @Copyright: 2018
 */
public class ImageComponent extends JComponent {
		private Icon icon;

		public ImageComponent(Icon icon) {
				this.icon = icon;
		}


		public Icon getIcon() {
				return icon;
		}

		public void setIcon(Icon icon) {
				this.icon = icon;
		}
		@Override
		public void paintComponent(Graphics g){
				super.paintComponent(g);
				int  w = icon.getIconWidth();
				int h = icon.getIconHeight();
				int x = (800 - w) /2;
				int y = (800 - h) /2;
				icon.paintIcon(this, g, x, y);
		}
}
