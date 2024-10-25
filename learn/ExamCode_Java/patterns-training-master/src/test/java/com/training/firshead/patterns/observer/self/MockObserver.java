/**
 * 
 */
package com.training.firshead.patterns.observer.self;

import com.training.firshead.patterns.observer.self.Observer;

/**
 * @author vkulinsky
 *         date: 04.01.2012
 *         time: 0:05:51
 * 
 */
public class MockObserver implements Observer {

	private float temp;
	private float humidity;
	private float pressure;
	private int numberOfNotifications;

	public void update(float temp, float humidity, float pressure) {
		numberOfNotifications++;
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
	}

	/**
	 * @return the temp
	 */
	public float getTemp() {
		return temp;
	}

	/**
	 * @return the humidity
	 */
	public float getHumidity() {
		return humidity;
	}

	/**
	 * @return the pressure
	 */
	public float getPressure() {
		return pressure;
	}

	/**
	 * @return the numberOfNotifications
	 */
	public int getNumberOfNotifications() {
		return numberOfNotifications;
	}

}
