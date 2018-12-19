package com.learn.functional.myself;

/**
 *
 * @author: WeFon
 * @date: 2018-11-20 16:40
 * @Copyright: 2018
 */
@FunctionalInterface
public interface ConsumerInterface<T> {
		/**
		 *
		 * @param t
		 */
		void accept(T t);

		default String ss(){
				return "ss";
		}
}
