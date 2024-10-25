/**
 * 
 */
package com.training.firshead.patterns.observer.self;

import com.training.firshead.patterns.observer.DisplayElement;

/**
 * Represents generic weather display element.
 * 
 * 
 * @author vkulinsky
 *         date: 03.01.2012
 *         time: 23:37:53
 * 
 */
public abstract class GenericWeatherDisplayElement implements Observer,
		DisplayElement {

	protected Subject weatherSubject;

	/**
	 * @param weatherSubject
	 */
	public GenericWeatherDisplayElement(Subject weatherSubject) {
		this.weatherSubject = weatherSubject;
		weatherSubject.registerObserver(this);
	}

}
