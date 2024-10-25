/**
 * 
 */
package com.training.firshead.patterns.abstractfactory.linux;

import java.util.Date;

import com.training.firshead.patterns.abstractfactory.DateField;


/**
 * @author vkulinsky
 * date: 11.01.2012
 * time: 0:00:32
 *
 */
public class LinuxDateField implements DateField{

	public static final String DISPLAY = "Linux date field";
	
	public String getDisplay() {
		return DISPLAY;
	}

	public Date getDate() {
		return null;
	}

	public void setDate(Date date) {
	}

}
