/**
 * 
 */
package com.training.firshead.patterns.decorator;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a cup of brazil coffee
 * 
 * @author vkulinsky
 * date: 08.01.2012
 * time: 23:47:53
 *
 */
public class BrasilCofee implements Coffee {
	
	static final double COST = 1.01;
	static final String DESCRIPTION = "Brazil coffee";

	public double getPrice() {
		return COST;
	}

	public List<String> getIngredients() {
		List<String> list = new ArrayList<String>();
		list.add(DESCRIPTION);
		return list;
	}

}
