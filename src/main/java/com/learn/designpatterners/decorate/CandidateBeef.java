package com.learn.designpatterners.decorate;

/**
 * @Description: 装饰的小对象
 * @author: WeFon
 * @date: 2018-10-26 17:13
 * @Copyright: 2018
 */
public class CandidateBeef extends Candidate {

		private OriginalCake originalCake;

		public CandidateBeef(OriginalCake originalCake) {
				this.originalCake = originalCake;
		}

		@Override
		public String getDescription() {
				return this.originalCake.getDescription() + ", 牛肉";
		}

		@Override
		public double price() {
				return this.originalCake.price() + 6;
		}
}
