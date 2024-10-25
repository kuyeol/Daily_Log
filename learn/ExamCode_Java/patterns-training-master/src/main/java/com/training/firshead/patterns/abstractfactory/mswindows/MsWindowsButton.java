/**
 * 
 */
package com.training.firshead.patterns.abstractfactory.mswindows;

import com.training.firshead.patterns.abstractfactory.Button;


/**
 * @author vkulinsky
 * date: 10.01.2012
 * time: 23:48:29
 *
 */
public class MsWindowsButton implements Button{

	public static final String DISPLAY = "Ms Windows button";
	
	public String getDisplay() {
		return DISPLAY;
	}

	public void push() {
	}

}
