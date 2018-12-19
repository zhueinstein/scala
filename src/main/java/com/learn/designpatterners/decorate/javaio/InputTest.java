package com.learn.designpatterners.decorate.javaio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 *
 * @author: WeFon
 * @date: 2018-10-28 22:30
 * @Copyright: 2018
 */
public class InputTest {

		public static void main(String[] args) throws Exception {
				int c;
				InputStream in = null;
				try {
						in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("/Users/zcx/IdeaProjects/scala/src/main/java/com/learn/designpatterners/decorate/javaio/test.txt")));
						while ((c = in.read()) >= 0) {
								System.out.print((char) c);
						}
				}finally {
					if(in != null){
							in.close();
					}
				}
		}
}
