/**
 * 
 */
package com.training.firshead.patterns.observer.j2se;

import java.util.Observable;
import java.util.Observer;

import com.training.firshead.patterns.observer.self.Subject;


/**
 * @author vkulinsky
 * date: 05.01.2012
 * time: 23:31:14
 *
 */
public class CurrentConditionsDisplay implements Observer {

	public static final String DISPLAY_PATTERN = "Current conditions:  temperature: %f , humidity:%f , pressure:%f";

	private float temperature;
	private float humidity;
	private float pressure;

	public String getDisplay() {
		return String.format(DISPLAY_PATTERN, temperature, humidity, pressure);
	}

	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		this.pressure = pressure;
	}
	
	public void update(Observable subject, Object obj) {
		if (subject instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)subject;
			temperature = weatherData.getTemperature() ;
			humidity = weatherData.getHumidity();
			pressure = weatherData.getPressure();
		}
	}

}
