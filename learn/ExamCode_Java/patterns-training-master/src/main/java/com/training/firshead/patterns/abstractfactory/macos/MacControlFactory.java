/**
 * 
 */
package com.training.firshead.patterns.abstractfactory.macos;

import com.training.firshead.patterns.abstractfactory.Button;
import com.training.firshead.patterns.abstractfactory.CheckBox;
import com.training.firshead.patterns.abstractfactory.ControlFactory;
import com.training.firshead.patterns.abstractfactory.DateField;
import com.training.firshead.patterns.abstractfactory.TextField;


/**
 * Control factory implementation that is responsible for creating
 * control in Mac style.
 * 
 * @author vkulinsky
 * date: 10.01.2012
 * time: 23:55:01
 *
 */
public class MacControlFactory implements ControlFactory{

	public CheckBox createCheckBox() {
		return new MacCheckBox();
	}

	public TextField createTextField() {
		return new MacTextField();
	}

	public DateField createDateField() {
		return new MacDateField();
	}

	public Button createButton() {
		return new MacButton();
	}

}
