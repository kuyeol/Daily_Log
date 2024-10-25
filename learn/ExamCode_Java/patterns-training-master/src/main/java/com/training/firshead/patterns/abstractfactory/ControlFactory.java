/**
 * 
 */
package com.training.firshead.patterns.abstractfactory;


/**
 * Represents abstract factory that is responsible for creating control.
 * 
 * @author vkulinsky
 * date: 10.01.2012
 * time: 23:38:21
 *
 */
public interface ControlFactory {
	
	CheckBox createCheckBox();
	
	TextField createTextField();
	
	DateField createDateField();
	
	Button createButton();

}
