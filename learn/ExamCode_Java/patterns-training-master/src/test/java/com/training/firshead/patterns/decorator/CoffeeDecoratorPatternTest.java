/**
 * 
 */
package com.training.firshead.patterns.decorator;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;


/**
 * @author vkulinsky
 * date: 09.01.2012
 * time: 0:00:50
 *
 */
public class CoffeeDecoratorPatternTest extends TestCase {

	
	public void testSimpleCoffee() {
		//check brazil coffee
		Coffee coffee = new BrasilCofee();
		assertCofeePrice("brazil coffee", coffee, BrasilCofee.COST);
		assertCoffeeIngredients("brazil coffee", coffee, Arrays.asList(BrasilCofee.DESCRIPTION));
		
		//check portugal coffee
		coffee = new PortugalCoffee();
		assertCofeePrice("portugal coffee", coffee, PortugalCoffee.COST);
		assertCoffeeIngredients("portugal coffee", coffee, Arrays.asList(PortugalCoffee.DESCRIPTION));
		
		//check delicious coffee
		coffee = new DeliciousCoffee();
		assertCofeePrice("delicious coffee", coffee, DeliciousCoffee.COST);
		assertCoffeeIngredients("delicious coffee", coffee, Arrays.asList(DeliciousCoffee.DESCRIPTION));
	}
	
	
	public void testBrazilCoffeeWithSugatMilkAndWhip() {
		Coffee coffee = new CoffeeWithWhip(new CoffeeWithMilk(
				new CoffeeWithSugar(new BrasilCofee())));
		
		String coffeeName = "Brazil cofee with sugar, milk and whip";
		assertCofeePrice(coffeeName, coffee, BrasilCofee.COST + CoffeeWithMilk.COST +
				CoffeeWithWhip.COST + CoffeeWithSugar.COST);
		
		assertCoffeeIngredients(coffeeName, coffee, 
				Arrays.asList(BrasilCofee.DESCRIPTION, CoffeeWithSugar.DESCRIPTION,
						CoffeeWithMilk.DESCRIPTION, CoffeeWithWhip.DESCRIPTION));
	}
	
	
	public void testPortigalCoffeeDoubleSugarAndWhip() {
		Coffee coffee = new CoffeeWithWhip(new CoffeeWithSugar(
				new CoffeeWithSugar(new PortugalCoffee())));
		
		String coffeeName = "Portugal cofee with double sugar and whip";
		assertCofeePrice(coffeeName, coffee, PortugalCoffee.COST + CoffeeWithSugar.COST +
				CoffeeWithSugar.COST + CoffeeWithWhip.COST);
		
		assertCoffeeIngredients(coffeeName, coffee, 
				Arrays.asList(PortugalCoffee.DESCRIPTION, CoffeeWithSugar.DESCRIPTION,
						CoffeeWithSugar.DESCRIPTION, CoffeeWithWhip.DESCRIPTION));
	}
	
	
	public void testDeliciousCoffeeWithMilk() {
		Coffee coffee = new CoffeeWithMilk(new DeliciousCoffee());
		
		String coffeeName = "Delicious cofee with milk";
		assertCofeePrice(coffeeName, coffee, DeliciousCoffee.COST + CoffeeWithMilk.COST);
		
		assertCoffeeIngredients(coffeeName, coffee, 
				Arrays.asList(DeliciousCoffee.DESCRIPTION, CoffeeWithMilk.DESCRIPTION));
	}
	
	
	
	private void assertCofeePrice(String coffeeName, Coffee coffee, double expectedPrice) {
		assertEquals(coffeeName+ ": unexpected coffee price", 
				expectedPrice, coffee.getPrice(), 0.01);
	}
	
	private void assertCoffeeIngredients(String coffeeName, Coffee coffee, List<String> ingredients) {
		
	  assertNotNull(coffeeName+": list of ingredients must not be null",
			  coffee.getIngredients());
	  assertEquals(coffeeName+": unexpected size of ingredients",
			  ingredients.size(), coffee.getIngredients().size());
	  assertEquals(coffeeName+": unexpected list of ingredients", 
			  toString(ingredients), toString(coffee.getIngredients()));
	}
	
	private static String toString(List<String> ingredients) {
		StringBuilder builder = new StringBuilder();
		for (String ingredient : ingredients)
			 builder.append(ingredient).append(",");
		return builder.toString();
	}
	
}
