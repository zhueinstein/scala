package com.learn.designpatterners.decorate;

/**
 * @Description: 装饰的小对象
 * @author: WeFon
 * @date: 2018-10-26 17:09
 * @Copyright: 2018
 */
public class CandidateFiredEgg extends Candidate {

		private OriginalCake originalCake;

		public CandidateFiredEgg(OriginalCake originalCake) {
				this.originalCake = originalCake;
		}

		@Override
		public String getDescription() {
				return this.originalCake.getDescription() + ", 煎蛋";
		}

		@Override
		public double price() {
				return this.originalCake.price() + 3;
		}
}
