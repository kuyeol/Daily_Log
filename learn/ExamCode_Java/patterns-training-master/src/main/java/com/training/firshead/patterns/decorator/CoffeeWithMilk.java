/**
 * 
 */
package com.training.firshead.patterns.decorator;

import java.util.List;


/**
 * @author vkulinsky
 * date: 08.01.2012
 * time: 23:55:36
 *
 */
public class CoffeeWithMilk extends CoffeeDecorator {

	static final double COST = .56;
	static final String DESCRIPTION = "Milk";
	
	/**
	 * @param decoratedCoffee
	 */
	public CoffeeWithMilk(Coffee decoratedCoffee) {
		super(decoratedCoffee);
	}

	
	@Override
	public double getPrice() {
		return decoratedCofee.getPrice() + COST;
	}

	@Override
	public List<String> getIngredients() {
		List<String> ingredients = decoratedCofee.getIngredients();
		ingredients.add(DESCRIPTION);
		return ingredients;
	}

}
