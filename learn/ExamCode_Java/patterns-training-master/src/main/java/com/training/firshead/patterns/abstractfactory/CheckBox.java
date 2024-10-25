/**
 * 
 */
package com.training.firshead.patterns.abstractfactory;


/**
 * Represents checkbox control.
 * 
 * @author vkulinsky
 * date: 10.01.2012
 * time: 23:29:13
 *
 */
public interface CheckBox extends Control{
	
	void setSelected(boolean selected);
	
	boolean getSelected();

}
