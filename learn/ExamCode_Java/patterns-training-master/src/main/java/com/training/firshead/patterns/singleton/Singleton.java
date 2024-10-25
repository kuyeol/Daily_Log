/**
 * 
 */
package com.training.firshead.patterns.singleton;


/**
 * Thread-safe singleton pattern implementation.
 * 
 * @author vkulinsky
 * date: 11.01.2012
 * time: 0:53:05
 *
 */
public class Singleton {
	
	private static volatile Singleton instance;
	
	//hide constructor from another classes
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		//following implementation guarantees thread-safe instance creation
		// also it provides deferred instance initialization (only the it's actually required)
		
		if (null == instance) {
			synchronized (Singleton.class) {
				if (null == instance)
				 instance = new Singleton();
			}
		}
		return instance;
	}

}
