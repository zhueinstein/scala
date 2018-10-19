package com.learn.netprograming;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Description: URL(Uniform Resource Locator)统一资源定位符，表示Internet上某一资源的地址，协议名：资源名称
 * @author: WeFon
 * @date: 2018-10-05 16:35
 * @Copyright: 2018
 */
public class URLDemo {

		public static void main(String[] args) throws IOException {
				// 创建一个URL实例
				URL baidu = new URL("http://www.baidu.com");
				URL url = new URL(baidu, "/index.html?username=tom#test");
				// 获取协议
				System.out.println(url.getProtocol());
				//  获取主机
				System.out.println(url.getHost());
				// 如果没有指定端口号，根据协议不同使用默认端口。此时getPort()方法的返回值为 -1
				System.out.println(url.getPort());
				// 获取文件路径
				System.out.println(url.getPath());
				// 获取文件名 包括 路径+ 参数
				System.out.println(url.getFile());
				//相对路径，就是锚点，即#号后面的内容
				System.out.println(url.getRef());
				// 查询字符串，即参数
				System.out.println(url.getQuery());

				// 通过URL对象的openStream()方法可以得到指定资源的输入流，通过流能够读取或访问网页上的资源
				//通过openStream方法获取资源的字节输入流
				InputStream inputStream = baidu.openStream();
				// 将字节输入流转换成字符输入流
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
				// 为字节流添加缓冲， 提高读写效率
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String data = bufferedReader.readLine();
				while (!StringUtils.isEmpty(data)){
						System.out.println(data);
						data = bufferedReader.readLine();
				}
				inputStream.close();
				inputStreamReader.close();
				bufferedReader.close();
		}
}
