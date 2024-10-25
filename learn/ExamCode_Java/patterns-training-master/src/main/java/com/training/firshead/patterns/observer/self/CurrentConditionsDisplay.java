/**
 * 
 */
package com.training.firshead.patterns.observer.self;

/**
 * @author vkulinsky
 *         date: 03.01.2012
 *         time: 23:36:55
 * 
 */
public class CurrentConditionsDisplay extends GenericWeatherDisplayElement {

	public static final String DISPLAY_PATTERN = "Current conditions:  temperature: %f , humidity:%f , pressure:%f";

	private float temperature;
	private float humidity;
	private float pressure;

	public CurrentConditionsDisplay(Subject weatherSubject) {
		super(weatherSubject);
	}

	public String getDisplay() {
		return String.format(DISPLAY_PATTERN, temperature, humidity, pressure);
	}

	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		this.pressure = pressure;
	}

}
