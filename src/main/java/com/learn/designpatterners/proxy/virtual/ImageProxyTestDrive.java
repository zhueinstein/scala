package com.learn.designpatterners.proxy.virtual;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-30 22:22
 * @Copyright: 2018
 */
public class ImageProxyTestDrive {
//		ImageCom imageComponent;
		public static void main(String[] args) throws MalformedURLException {
				ImageProxyTestDrive testDrive = new ImageProxyTestDrive();
		}

		public ImageProxyTestDrive() throws MalformedURLException {
				URL  initUrl = new URL("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=CD&step_word=&hs=0&pn=0&spn=0&di=35086760410&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=2&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=-1&cs=1125251620%2C1004944136&os=2971902120%2C1562349829&simid=2091069691%2C831644433&adpicid=0&lpn=0&ln=1873&fr=&fmq=1540909962280_R&fm=index&ic=0&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&ist=&jit=&cg=&bdtype=13&oriquery=&objurl=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F4034970a304e251f734617d1ac86c9177f3e5362.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Frwtxtg_z%26e3Bv54AzdH3Fri5p5v5ry6t2ipAzdH3F8cnlbl00m&gsm=0&rpstart=0&rpnum=0&islist=&querylist=");
				Icon icon = new ImageProxy(initUrl);


		}
}
