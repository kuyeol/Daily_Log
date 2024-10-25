/**
 * 
 */
package com.training.firshead.patterns.observer.self;

/**
 * Defines "subject" interface in "observer" pattern.
 * 
 * @author vkulinsky
 *         date: 03.01.2012
 *         time: 23:21:45
 * 
 */
public interface Subject {

	/**
	 * Register observer into subscription list
	 * 
	 * @param observer
	 *           observer to be registered
	 */
	void registerObserver(Observer observer);

	/**
	 * Remove the given observer from subscription list.
	 * 
	 * @param observer
	 */
	void deleteObserver(Observer observer);

	/**
	 * Notify all the registered observer that the subject state has been changed
	 */
	void notifyObservers();
}
