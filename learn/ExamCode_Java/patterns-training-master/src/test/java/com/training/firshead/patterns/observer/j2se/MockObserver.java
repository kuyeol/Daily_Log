/**
 * 
 */
package com.training.firshead.patterns.observer.j2se;

import java.util.Observable;
import java.util.Observer;

/**
 * @author vkulinsky
 *         date: 05.01.2012
 *         time: 23:37:19
 * 
 */
public class MockObserver implements Observer {

	private float temp;
	private float humidity;
	private float pressure;
	private int numberOfNotifications;

	public void update(Observable o, Object arg) {
		WeatherData weatheData = (WeatherData) o;
		temp = weatheData.getTemperature();
		humidity = weatheData.getHumidity();
		pressure = weatheData.getPressure();
		numberOfNotifications++;
	}

	/**
	 * @return the numberOfNotifications
	 */
	public int getNumberOfNotifications() {
		return numberOfNotifications;
	}

	/**
	 * @param numberOfNotifications
	 *           the numberOfNotifications to set
	 */
	public void setNumberOfNotifications(int numberOfNotifications) {
		this.numberOfNotifications = numberOfNotifications;
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

}
