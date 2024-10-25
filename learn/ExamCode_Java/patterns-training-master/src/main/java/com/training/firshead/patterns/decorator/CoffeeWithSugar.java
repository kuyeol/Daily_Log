/**
 * 
 */
package com.training.firshead.patterns.decorator;

import java.util.List;


/**
 * @author vkulinsky
 * date: 08.01.2012
 * time: 23:57:55
 *
 */
public class CoffeeWithSugar extends CoffeeDecorator {

	static final double COST = .12;
	static final String DESCRIPTION = "Sugar";

	/**
	 * @param decoratedCoffee
	 */
	public CoffeeWithSugar(Coffee decoratedCoffee) {
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
