package com.learn.designpatterners.decorate.starbucks;

/**
 *
 * @author: WeFon
 * @date: 2018-10-28 21:48
 * @Copyright: 2018
 */
public enum Volume {
		TALL("TALL"),
		GRANDE("GRANDE"),
		VENTI("VENTI");

		private String volume;

		Volume(String volume) {
				this.volume = volume;
		}

		public String getVolume() {
				return this.volume;
		}
}
