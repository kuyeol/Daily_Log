/**
 * 
 */
package com.training.firshead.patterns.abstractfactory.linux;

import com.training.firshead.patterns.abstractfactory.TextField;


/**
 * @author vkulinsky
 * date: 10.01.2012
 * time: 23:59:39
 *
 */
public class LinuxTextField implements TextField{
   
	public static final String DISPLAY = "Linux text field";
	
	public String getDisplay() {
		return DISPLAY;
	}

	public String getText() {
		return null;
	}

	public void setText(String text) {
	}

}
