/**
 * 
 */
package com.training.firshead.patterns.decorator;

import java.util.List;


/**
 * Represetns basic class of all the coffee decorators.
 * 
 * 
 * @author vkulinsky
 * date: 08.01.2012
 * time: 23:43:11
 *
 */
public abstract class CoffeeDecorator implements Coffee {

	protected Coffee decoratedCofee;
	
	/**
	 * @param decoratedCoffee
	 */
	public CoffeeDecorator(Coffee decoratedCoffee) {
		super();
		this.decoratedCofee = decoratedCoffee;
	}

	
	public abstract double getPrice();
	
	
	public abstract List<String> getIngredients();

}
