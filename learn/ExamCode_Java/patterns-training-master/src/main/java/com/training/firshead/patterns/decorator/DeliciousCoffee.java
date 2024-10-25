/**
 * 
 */
package com.training.firshead.patterns.decorator;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a cup of some sort of delicious coffee :). 
 * 
 * @author vkulinsky
 * date: 08.01.2012
 * time: 23:51:48
 *
 */
public class DeliciousCoffee implements Coffee {

	static final double COST = 1.87;
	static final String DESCRIPTION = "Delicious coffee";
	
	public double getPrice() {
		return COST;
	}

	public List<String> getIngredients() {
		List<String> list = new ArrayList<String>();
		list.add(DESCRIPTION);
		return list;
	}

}
