/**
 * 
 */
package com.training.firshead.patterns.abstractfactory.mswindows;

import java.util.Date;

import com.training.firshead.patterns.abstractfactory.DateField;


/**
 * @author vkulinsky
 * date: 10.01.2012
 * time: 23:47:26
 *
 */
public class MsWindowsDateField implements DateField{

	public static final String DISPLAY = "Ms Windows date field";
	
	public String getDisplay() {
		return DISPLAY;
	}

	public Date getDate() {
		return null;
	}

	public void setDate(Date date) {
	}

}
