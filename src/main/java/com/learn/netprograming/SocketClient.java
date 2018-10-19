package com.learn.netprograming;

import org.springframework.util.StringUtils;

import java.io.*;
import java.net.Socket;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-05 17:05
 * @Copyright: 2018
 */
public class SocketClient {

		public static void main(String[] args) throws IOException {
				Socket socket = new Socket("localhost", 8077);
				OutputStream outputStream = socket.getOutputStream();
				PrintWriter printWriter = new PrintWriter(outputStream);
				printWriter.write("用户名：admin；密码：123");
				printWriter.flush();
				socket.shutdownOutput();
				InputStream inputStream = socket.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String data = bufferedReader.readLine();
				while (!StringUtils.isEmpty(data)){
						System.out.println("我是客户端, 服务器反应说 = "+ data);
						data = bufferedReader.readLine();
				}
				outputStream.close();
				printWriter.close();
				inputStream.close();
				inputStreamReader.close();
				bufferedReader.close();
		}
}
