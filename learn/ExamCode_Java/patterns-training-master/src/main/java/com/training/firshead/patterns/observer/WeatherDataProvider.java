/**
 * 
 */
package com.training.firshead.patterns.observer;

/**
 * @author vkulinsky
 *         date: 05.01.2012
 *         time: 23:24:55
 * 
 */
public interface WeatherDataProvider {

	float getTemperature();

	float getHumidity();

	float getPressure();

	void measurementsChanged();

	void setMeasurements(float temp, float humidity, float pressure);
}
