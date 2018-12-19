package com.learn.threadlearn.producer201808.communication20180815;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author: WeFon
 * @date: 2018-08-15 23:02
 * @Copyright: 2018
 */
public class PipedCommunication {
		PipedInputStream pipedInputStream = new PipedInputStream();
		PipedOutputStream pipedOutputStream = new PipedOutputStream();

		public void write() {
				System.out.println("Write: ");
				for (int i = 0; i < 100; i++) {
						String data = i + "0";
						try {
								pipedOutputStream.write(data.getBytes());
						} catch (IOException e) {
								e.printStackTrace();
						} finally {

						}
				}
				System.out.println();
				try {
						pipedOutputStream.close();

				} catch (IOException e) {
						e.printStackTrace();
				}
		}

		public void read() {
				System.out.println("Read: ");
				try {
						byte[] bytes = new byte[20];
						int readLength = pipedInputStream.read(bytes);
						while (readLength != -1) {
								String data = new String(bytes, 0, readLength);
								System.out.println(data);
								readLength = pipedInputStream.read(bytes);
						}
						System.out.println();
						pipedInputStream.close();
				} catch (Exception ex) {
						ex.printStackTrace();
				}
		}

		public static void main(String[] args) throws IOException, InterruptedException {
				PipedCommunication pipedCommunication = new PipedCommunication();

				// 管道建立连接
				pipedCommunication.pipedInputStream.connect(pipedCommunication.pipedOutputStream);

				ExecutorService executorService = Executors.newCachedThreadPool();

				executorService.execute(() -> pipedCommunication.write());

				Thread.sleep(2000);

				executorService.execute(() -> pipedCommunication.read());
		}
}
