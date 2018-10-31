package com.learn.designpatterners.proxy.dynamic;

import com.learn.designpatterners.observer.Person;

import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-30 23:37
 * @Copyright: 2018
 */
public class MatchMakingTestDrive {

		public static void main(String[] args) {
				MatchMakingTestDrive testDrive = new MatchMakingTestDrive();
				testDrive.drive();
		}

		private void drive() {
				PersonBean joe = getPersonFromDataBase("Joe JavaBean");
				PersonBean ownerProxy = getOwnerBean(joe);
				System.out.println(Proxy.isProxyClass(ownerProxy.getClass()));
				System.out.println("Name is " + ownerProxy.getName());
				ownerProxy.setInterests(" blowing Go");
				System.out.println("Interest set from owner proxy");

				try{
						ownerProxy.setHotOrNotRating(100);
				}catch (Exception ex){
						System.out.println("Can not set rating from owner proxy");
				}

				System.out.println("Rating is " + ownerProxy.getHotOrNotRating());

				PersonBean nonOwnerProxy = getNonOwnerBean(joe);
				System.out.println("Name is " + nonOwnerProxy.getName());

				try{
						nonOwnerProxy.setInterests("blowing Go");
				}catch (Exception ex){
						System.out.println("Can not set interests from non owner proxy");
				}
				System.out.println("Interests is " + nonOwnerProxy.getInterests());

				nonOwnerProxy.setHotOrNotRating(3);
				System.out.println("rating set from non owner proxy");
				System.out.println("rating is " + nonOwnerProxy.getHotOrNotRating());

		}

		private PersonBean getPersonFromDataBase(String s) {
				PersonBean personBean = new PersonBeanImpl();
				personBean.setName(s);
				personBean.setGender("男");
				personBean.setInterests("Run, Sleep, Sing");
				personBean.setHotOrNotRating(new Random(100).nextInt());
				return personBean;
		}

		public PersonBean getOwnerBean(PersonBean personBean) {
				return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(), personBean.getClass().getInterfaces(), new OwnerInvocationHandler(personBean));

		}

		public PersonBean getNonOwnerBean(PersonBean personBean){
				return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(), personBean.getClass().getInterfaces(), new NonOwnerInvocationHandler(personBean));
		}
}
