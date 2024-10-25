/**
 * 
 */
package com.training.firshead.patterns.abstractfactory.macos;

import com.training.firshead.patterns.abstractfactory.TextField;


/**
 * @author vkulinsky
 * date: 10.01.2012
 * time: 23:51:56
 *
 */
public class MacTextField implements TextField	{

	public static final String DISPLAY = "Mac text field";
	
	public String getDisplay() {
		return DISPLAY;
	}

	public String getText() {
		return null;
	}

	public void setText(String text) {
	}
	
}
