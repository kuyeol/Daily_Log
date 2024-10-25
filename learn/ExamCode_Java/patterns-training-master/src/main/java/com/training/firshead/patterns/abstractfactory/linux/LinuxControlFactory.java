/**
 * 
 */
package com.training.firshead.patterns.abstractfactory.linux;

import com.training.firshead.patterns.abstractfactory.Button;
import com.training.firshead.patterns.abstractfactory.CheckBox;
import com.training.firshead.patterns.abstractfactory.ControlFactory;
import com.training.firshead.patterns.abstractfactory.DateField;
import com.training.firshead.patterns.abstractfactory.TextField;


/**
 * Control factory implementation that is responsible for creating 
 * controls in Linux style.
 * 
 * @author vkulinsky
 * date: 11.01.2012
 * time: 0:01:40
 *
 */
public class LinuxControlFactory implements ControlFactory{

	public CheckBox createCheckBox() {
		return new LinuxCheckBox();
	}

	public TextField createTextField() {
		return new LinuxTextField();
	}

	public DateField createDateField() {
		return new LinuxDateField();
	}

	public Button createButton() {
		return new LinuxButton();
	}

}
