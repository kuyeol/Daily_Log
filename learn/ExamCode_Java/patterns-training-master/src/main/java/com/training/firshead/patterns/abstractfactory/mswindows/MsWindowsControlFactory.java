/**
 * 
 */
package com.training.firshead.patterns.abstractfactory.mswindows;

import com.training.firshead.patterns.abstractfactory.Button;
import com.training.firshead.patterns.abstractfactory.CheckBox;
import com.training.firshead.patterns.abstractfactory.ControlFactory;
import com.training.firshead.patterns.abstractfactory.DateField;
import com.training.firshead.patterns.abstractfactory.TextField;


/**
 * Concrete implementation of control factory that is responsible for
 * creating MS Windows styled control.
 * 
 * @author vkulinsky
 * date: 10.01.2012
 * time: 23:49:34
 *
 */
public class MsWindowsControlFactory implements ControlFactory{

	public CheckBox createCheckBox() {
		return new MsWindowsCheckBox();
	}

	public TextField createTextField() {
		return new MsWindowsTextField();
	}

	public DateField createDateField() {
		return new MsWindowsDateField();
	}

	public Button createButton() {
		return new MsWindowsButton();
	}

}
