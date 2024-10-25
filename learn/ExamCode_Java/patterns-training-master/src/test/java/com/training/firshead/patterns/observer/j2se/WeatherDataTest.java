/**
 * 
 */
package com.training.firshead.patterns.observer.j2se;

import junit.framework.TestCase;

/**
 * @author vkulinsky
 *         date: 05.01.2012
 *         time: 23:35:19
 * 
 */
public class WeatherDataTest extends TestCase {

	private WeatherData weatherData;

	@Override
	protected void setUp() throws Exception {
		weatherData = new WeatherData();
	}

	@Override
	protected void tearDown() throws Exception {
		weatherData = null;
	}

	public void testRegisterObserver() {
		weatherData.addObserver(new MockObserver());
		assertEquals("Only a single observer must be registered", 1,
				weatherData.countObservers());
	}

	public void testDeleteObserver() {
		MockObserver observer = new MockObserver();
		weatherData.addObserver(observer);

		weatherData.deleteObserver(observer);
		assertEquals("No observer must retain ", 0, weatherData.countObservers());
	}

	public void testNotifyObservers() {
		MockObserver mockObserver = new MockObserver();

		weatherData.addObserver(mockObserver);
		weatherData.setMeasurements(10f, 20f, 30f);

		assertEquals("Unexpected temperature value", 10f, mockObserver.getTemp(),
				0);
		assertEquals("Unexpected humidity value", 20f,
				mockObserver.getHumidity(), 0);
		assertEquals("Unexpected pressure value", 30f,
				mockObserver.getPressure(), 0);
		assertEquals("Unexpected number of notifications", 1,
				mockObserver.getNumberOfNotifications());
	}

	public void testSetMeasurements() {
		weatherData.setMeasurements(10f, 20f, 30f);

		assertEquals("Unexpected temperature value", 10f,
				weatherData.getTemperature(), 0);
		assertEquals("Unexpected humidity value", 20f, weatherData.getHumidity(),
				0);
		assertEquals("Unexpected pressure value", 30f, weatherData.getPressure(),
				0);
	}

}
