/**
 * 
 */
package com.training.firshead.patterns.decorator;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a cup of portugal coffee
 * 
 * @author vkulinsky
 * date: 08.01.2012
 * time: 23:50:08
 *
 */
public class PortugalCoffee implements Coffee {

	static final double COST = 1.101;
	static final String DESCRIPTION = "Portugal coffee";
	
	
	public double getPrice() {
		return COST;
	}

	public List<String> getIngredients() {
		List<String> list = new ArrayList<String>();
		list.add(DESCRIPTION);
		return list;
	}

}
