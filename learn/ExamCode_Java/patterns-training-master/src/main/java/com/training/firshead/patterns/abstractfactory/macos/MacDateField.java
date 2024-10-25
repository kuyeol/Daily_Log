/**
 * 
 */
package com.training.firshead.patterns.abstractfactory.macos;

import java.util.Date;

import com.training.firshead.patterns.abstractfactory.DateField;


/**
 * @author vkulinsky
 * date: 10.01.2012
 * time: 23:53:13
 *
 */
public class MacDateField implements DateField{

	public static final String DISPLAY = "Mac date field";
	
	public String getDisplay() {
		return DISPLAY;
	}

	public Date getDate() {
		return null;
	}

	public void setDate(Date date) {
	}
}
