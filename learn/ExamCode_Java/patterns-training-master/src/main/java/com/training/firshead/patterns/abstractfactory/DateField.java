/**
 * 
 */
package com.training.firshead.patterns.abstractfactory;

import java.util.Date;

/**
 * Date field control - provide an ability to select the date from calendar.
 * 
 * @author vkulinsky
 * date: 10.01.2012
 * time: 23:30:45
 *
 */
public interface DateField extends Control{
	
	Date getDate();
	
	void setDate(Date date);

}
