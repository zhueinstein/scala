package com.learn.designpatterners.proxy.dynamic;

/**
 *
 * @author: WeFon
 * @date: 2018-10-30 22:51
 * @Copyright: 2018
 */
public interface PersonBean {
		String getName();
		String getGender();
		String getInterests();
		int getHotOrNotRating();

		void setName(String name);
		void setGender(String gender);
		void setInterests(String interests);
		void setHotOrNotRating(int rating);
}
