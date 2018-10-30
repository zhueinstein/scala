package com.learn.designpatterners.decorate.beifeng;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-28 19:45
 * @Copyright: 2018
 */
public class MainClass {

		public static void main(String[] args) {
				Car swimCar = new ModelCar();
				SwimDecorator swimDecorator = new SwimDecorator(swimCar);
				FlyDecorator flyDecorator = new FlyDecorator(swimDecorator);
				flyDecorator.fun();
		}
}
