/**
 * 
 */
package com.training.firshead.patterns.observer.self;

/**
 * @author vkulinsky
 *         date: 03.01.2012
 *         time: 23:46:11
 * 
 */
public class StatisticsWeatherDisplay extends GenericWeatherDisplayElement {

	public static final String DISPLAY_PATTERN = "Min/Max temp: %f , %f";
	private boolean firstUpdate = true;
	private float minTemp;
	private float maxTemp;

	public StatisticsWeatherDisplay(Subject weatherSubject) {
		super(weatherSubject);
	}

	public void update(float temp, float humidity, float pressure) {
		if (firstUpdate) {
			minTemp = temp;
			maxTemp = temp;
			firstUpdate = false;
		} else {
			if (temp < minTemp) minTemp = temp;
			if (maxTemp < temp) maxTemp = temp;
		}
	}

	public String getDisplay() {
		return String.format(DISPLAY_PATTERN, minTemp, maxTemp);
	}

}
