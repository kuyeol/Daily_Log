/**
 * 
 */
package com.training.firshead.patterns.abstractfactory;


/**
 * Represents generic control interface. <br>
 * Contains only a single method that returns graphical presentation of the control.
 * 
 * @author vkulinsky
 * date: 10.01.2012
 * time: 23:26:39
 *
 */
public interface Control {
	
	/**
	 * Returns graphical presentation of the control
	 * 
	 * @return graphical presentation of the control
	 */
	String getDisplay();

}
