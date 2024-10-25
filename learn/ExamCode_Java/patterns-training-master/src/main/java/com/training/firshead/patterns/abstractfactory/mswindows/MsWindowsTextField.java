package com.training.firshead.patterns.abstractfactory.mswindows;

import com.training.firshead.patterns.abstractfactory.TextField;


/**
 * 
 */

/**
 * @author vkulinsky
 * date: 10.01.2012
 * time: 23:45:55
 *
 */
public class MsWindowsTextField implements TextField{

	public static final String DISPLAY = "Ms Windows text field";
	
	public String getDisplay() {
	  return DISPLAY;
	}

	public String getText() {
		return null;
	}

	public void setText(String text) {
	}

	
}
