package com.learn.designpatterners.decorate.javaio;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: 实现自己的io功能
 * @author: WeFon
 * @date: 2018-10-28 22:23
 * @Copyright: 2018
 */
public class LowerCaseInputStream extends FilterInputStream {

		public LowerCaseInputStream(InputStream in) {
				super(in);
		}

		@Override
		public int read() throws IOException {
				int c = super.read();
				return (c == -1?c:Character.toLowerCase(c));
		}

		@Override
		public int read(byte[] b, int off, int len) throws IOException {
				int result = super.read(b, off, len);
				for(int i = off; i < off + result; i ++){
						int c = b[i];
						b[i] = (byte) (c == -1?c:Character.toLowerCase(c));
				}
				return result;
		}
}
