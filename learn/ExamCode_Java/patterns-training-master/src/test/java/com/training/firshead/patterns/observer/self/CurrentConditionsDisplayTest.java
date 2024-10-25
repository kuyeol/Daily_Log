/**
 * 
 */
package com.training.firshead.patterns.observer.self;

import junit.framework.TestCase;

/**
 * @author vkulinsky
 *         date: 04.01.2012
 *         time: 0:35:06
 * 
 */
public class CurrentConditionsDisplayTest extends TestCase {

	private WeatherData weatherData;
	private CurrentConditionsDisplay display;

	@Override
	protected void setUp() throws Exception {
		weatherData = new WeatherData();
		display = new CurrentConditionsDisplay(weatherData);
	}

	@Override
	protected void tearDown() throws Exception {
		display = null;
		weatherData = null;

	}

	public void testRegisterObserver() {
		assertEquals("Unexpected number of observers", 1,
				weatherData.observers.size());
	}

	public void testDisplay() {
		weatherData.setMeasurements(10f, 20f, 30f);
		String expectedDisplay = String.format(
				CurrentConditionsDisplay.DISPLAY_PATTERN, 10f, 20f, 30f);
		assertEquals("Unexpected display result", expectedDisplay,
				display.getDisplay());

		weatherData.setMeasurements(15f, 25f, 35f);
		expectedDisplay = String.format(CurrentConditionsDisplay.DISPLAY_PATTERN,
				15f, 25f, 35f);
		assertEquals("Unexpected display result", expectedDisplay,
				display.getDisplay());

	}
}
