package com.learn.designpatterners.factory.pizza2.pizza;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-29 20:49
 * @Copyright: 2018
 */
public class SimplePizzaFactory {

		public Pizza createPizza(String type){
				Pizza pizza = null;

				if(type.equals("cheese")){
						pizza = new CheesePizza();
				}else if(type.equals("pepperoni")){
						pizza = new PepperoniPizza();
				}else if(type.equals("clam")){
						pizza = new ClamPizza();
				}else if(type.equals("veggie")){
						pizza = new VeggiePizza();
				}
				return pizza;
		}
}
