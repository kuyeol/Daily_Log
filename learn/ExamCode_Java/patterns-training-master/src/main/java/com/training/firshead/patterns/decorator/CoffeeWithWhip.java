/**
 * 
 */
package com.training.firshead.patterns.decorator;

import java.util.List;


/**
 * @author vkulinsky
 * date: 08.01.2012
 * time: 23:59:13
 *
 */
public class CoffeeWithWhip extends CoffeeDecorator {

	static final double COST = .49;
	static final String DESCRIPTION = "Whip";

	/**
	 * @param decoratedCoffee
	 */
	public CoffeeWithWhip(Coffee decoratedCoffee) {
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
