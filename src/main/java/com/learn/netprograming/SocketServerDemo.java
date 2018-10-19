package com.learn.netprograming;

import com.fasterxml.jackson.core.util.BufferRecycler;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-05 16:55
 * @Copyright: 2018
 */
public class SocketServerDemo {

		public static void main(String[] args) throws IOException {
				// 创建一个socket Server, 指定绑定端口
				ServerSocket serverSocket = new ServerSocket(8077);

				while (true) {
						// 开启监听, 等待客户端的连接
						Socket socket = serverSocket.accept();
						// 获取输入流， 并读取客户端发送的消息
						InputStream inputStream = socket.getInputStream();
						InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
						BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
						String data = bufferedReader.readLine();
						while (!StringUtils.isEmpty(data)) {
								System.out.println("我是服务器, 客户端说 = " + data);
								data = bufferedReader.readLine();
						}
						// 获取输出流，回应客户端
						OutputStream outputStream = socket.getOutputStream();
						PrintWriter printWriter = new PrintWriter(outputStream);
						printWriter.write("我是服务器，回应的数据, 你好");
						printWriter.flush();

						inputStream.close();
						inputStream.close();
						bufferedReader.close();
						outputStream.close();
						printWriter.close();

				}

		}
}
