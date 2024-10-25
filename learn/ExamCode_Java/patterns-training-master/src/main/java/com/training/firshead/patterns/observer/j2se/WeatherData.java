/**
 * 
 */
package com.training.firshead.patterns.observer.j2se;

import java.util.Observable;

import com.training.firshead.patterns.observer.WeatherDataProvider;


/**
 * "Object pattern" subject implementation based on {@link Observable} class.
 * 
 * @author vkulinsky
 * date: 05.01.2012
 * time: 23:24:28
 *
 */
public class WeatherData extends Observable implements WeatherDataProvider {

	private float temperature;
	private float humidity;
	private float pressure;
	
	/**
	 * @return the temperature
	 */
	public float getTemperature() {
		return temperature;
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

	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}

	public void setMeasurements(float temp, float humidity, float pressure) {
		temperature = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	
}
