package com.learn.netprograming;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description: InetAddress类用于标识网络上的硬件资源，标识互联网协议(IP)地址.。该类没有构造方法
 * @author: WeFon
 * @date: 2018-10-05 16:22
 * @Copyright: 2018
 */
public class InetAddressDemo {

		public static void main(String[] args) throws UnknownHostException {
				// 获取本机的inetAddres实例
				InetAddress address = InetAddress.getLocalHost();

				// 获取计算机名称
				System.out.println(address.getHostName());
				// 获取IP地址
				System.out.println(address.getHostAddress());
				// 获取字节数组形式的ip地址
				byte[] bytes = address.getAddress();
				System.out.println(String.format("%s.%s.%s.%s", bytes[0], bytes[1], bytes[2], bytes[3]));

				// 获取其他ip的inet对象
				byte[] iptabs = new byte[]{10, 19, 19, 52};
				InetAddress address1 = InetAddress.getByAddress(iptabs);
				InetAddress address2 = InetAddress.getByName("10.19.19.52");
				System.out.println(address2.getHostName());

		}
}
