package com.learn.designpatterners.observer.mydesign;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Observer;

/**
 * @Description: 自定的 被观察者对象， 需要维护观察者列表， 维护依赖关系
 * @author: WeFon
 * @date: 2018-10-26 14:58
 * @Copyright: 2018
 */
public class VeeObserable {
		boolean isChange = false;

		List<VeeObserver> observers = Lists.newArrayList();
		/**
		 * 默认是true
		 * @param change
		 */
		public void setChanged(Boolean ... change){
				if(change.length > 0){
						this.isChange = change[0];
				}else{
						this.isChange = Boolean.TRUE;
				}
		}

		public void addObserver(VeeObserver observer){
				this.observers.add(observer);
		}

		public void noticeAll(){
				observers.stream().forEach(ds -> {
						if(isChange){
								ds.update();
						}
				});
		}

		public void deleteObserver(Observer observer){
				observers.remove(observer);
		}
}
