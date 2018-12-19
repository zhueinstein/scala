package com.learn;

import java.io.UnsupportedEncodingException;

/**
 * @author： ZhuWeiFeng
 * @date： 2018/4/11
 */
public class CharDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
			char s = '是';
			System.out.println("是".getBytes("UTF-8").length);
			System.out.println("是是".getBytes("UTF-8").length);
			System.out.println("是".getBytes("GBK").length);
			System.out.println("是是".getBytes("GBK").length);
	}
}
