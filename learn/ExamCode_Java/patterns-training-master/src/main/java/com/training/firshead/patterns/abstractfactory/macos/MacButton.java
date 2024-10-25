/**
 * 
 */
package com.training.firshead.patterns.abstractfactory.macos;

import com.training.firshead.patterns.abstractfactory.Button;


/**
 * @author vkulinsky
 * date: 10.01.2012
 * time: 23:54:17
 *
 */
public class MacButton implements Button{

	public static final String DISPLAY = "Mac button";
	
	public String getDisplay() {
		return DISPLAY;
	}

	public void push() {
	}

}
