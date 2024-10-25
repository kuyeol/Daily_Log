/**
 * 
 */
package com.training.firshead.patterns.observer.self;

import junit.framework.TestCase;

/**
 * @author vkulinsky
 *         date: 04.01.2012
 *         time: 0:40:56
 * 
 */
public class StatisticsWeatherDisplayTest extends TestCase {

	private WeatherData weatherData;
	private StatisticsWeatherDisplay display;

	@Override
	protected void setUp() throws Exception {
		weatherData = new WeatherData();
		display = new StatisticsWeatherDisplay(weatherData);
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
				StatisticsWeatherDisplay.DISPLAY_PATTERN, 10f, 10f);
		assertEquals("Unexpected display result during initial execution",
				expectedDisplay, display.getDisplay());

		weatherData.setMeasurements(20f, 20f, 30f);
		expectedDisplay = String.format(StatisticsWeatherDisplay.DISPLAY_PATTERN,
				10f, 20f);
		assertEquals("Unexpected display result during max check",
				expectedDisplay, display.getDisplay());

		weatherData.setMeasurements(5f, 20f, 30f);
		expectedDisplay = String.format(StatisticsWeatherDisplay.DISPLAY_PATTERN,
				5f, 20f);
		assertEquals("Unexpected display result during min check",
				expectedDisplay, display.getDisplay());

	}

}
