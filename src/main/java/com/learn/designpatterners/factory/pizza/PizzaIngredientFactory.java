package com.learn.designpatterners.factory.pizza;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-10-29 21:44
 * @Copyright: 2018
 */
public interface PizzaIngredientFactory {

		Dough createDough();
		Sauce createSauce();
		Cheese createCheese();
		Veggie[] createVeggie();
		Pepperoni createPepperoni();
		Clams createClams();

}
