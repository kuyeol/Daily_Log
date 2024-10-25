/**
 * 
 */
package com.training.firshead.patterns.observer.self;

import java.util.ArrayList;
import java.util.List;

import com.training.firshead.patterns.observer.WeatherDataProvider;

/**
 * Simple subject implementation.
 * 
 * @author vkulinsky
 *         date: 03.01.2012
 *         time: 23:24:21
 * 
 */
public class WeatherData implements Subject, WeatherDataProvider {

	protected List<Observer> observers = new ArrayList<Observer>();

	private float temperature;
	private float humidity;
	private float pressure;

	public void registerObserver(Observer observer) {
		if (observers.indexOf(observer) < 0) observers.add(observer);
	}

	public void deleteObserver(Observer observer) {
		if (observers.indexOf(observer) >= 0) observers.remove(observer);
	}

	public void notifyObservers() {
		for (Observer observer : observers)
			observer.update(temperature, humidity, pressure);

	}

	public void measurementsChanged() {
		notifyObservers();
	}

	public void setMeasurements(float temp, float humidity, float pressure) {
		temperature = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

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

}
