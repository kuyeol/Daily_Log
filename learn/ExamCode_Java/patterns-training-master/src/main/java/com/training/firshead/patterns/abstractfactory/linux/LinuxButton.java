/**
 * 
 */
package com.training.firshead.patterns.abstractfactory.linux;

import com.training.firshead.patterns.abstractfactory.Button;


/**
 * @author vkulinsky
 * date: 11.01.2012
 * time: 0:01:07
 *
 */
public class LinuxButton implements Button{

	public static final String DISPLAY = "Linux button";
	
	public String getDisplay() {
		return DISPLAY;
	}

	public void push() {
	}

}
