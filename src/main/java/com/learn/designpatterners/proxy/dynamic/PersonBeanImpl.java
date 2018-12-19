package com.learn.designpatterners.proxy.dynamic;

/**
 *
 * @author: WeFon
 * @date: 2018-10-30 22:53
 * @Copyright: 2018
 */
public class PersonBeanImpl implements PersonBean{
		String name;
		String gender;
		String interests;
		int hotOrNotRating;
		int ratingCount = 0;
		@Override
		public String getName() {
				return name;
		}

		@Override
		public String getGender() {
				return gender;
		}

		@Override
		public String getInterests() {
				return interests;
		}

		@Override
		public int getHotOrNotRating() {
				return hotOrNotRating;
		}

		@Override
		public void setName(String name) {
			this.name = name;
		}

		@Override
		public void setGender(String gender) {
				this.gender = gender;
		}

		@Override
		public void setInterests(String interests) {
				this.interests = interests;
		}

		@Override
		public void setHotOrNotRating(int rating) {
				this.hotOrNotRating = rating;
				ratingCount ++;
		}
}
