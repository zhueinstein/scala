package com.learn.functional.myself;

/**
 * @author: WeFon
 * @date: 2018-11-20 16:54
 * @Copyright: 2018
 */
@FunctionalInterface
public interface SplitInterface<T> {
		/**
		 *
		 * @param t
		 * @return
		 */
		T[] split(T t);

}
