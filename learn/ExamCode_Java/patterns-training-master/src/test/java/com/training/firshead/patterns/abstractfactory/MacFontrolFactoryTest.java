/**
 * 
 */
package com.training.firshead.patterns.abstractfactory;

import com.training.firshead.patterns.abstractfactory.macos.MacButton;
import com.training.firshead.patterns.abstractfactory.macos.MacCheckBox;
import com.training.firshead.patterns.abstractfactory.macos.MacControlFactory;
import com.training.firshead.patterns.abstractfactory.macos.MacDateField;
import com.training.firshead.patterns.abstractfactory.macos.MacTextField;


/**
 * @author vkulinsky
 * date: 11.01.2012
 * time: 0:29:32
 *
 */
public class MacFontrolFactoryTest extends GenericControlFactoryTest{

	@Override
	protected ControlFactory createControlFactory() {
		return new MacControlFactory();
	}

	@Override
	protected Class<? extends CheckBox> getExpectedCheckboxClass() {
		return MacCheckBox.class;
	}

	@Override
	protected Class<? extends TextField> getExpectedTextFieldClass() {
		return MacTextField.class;
	}

	@Override
	protected Class<? extends DateField> getExpectedDateFieldClass() {
		return MacDateField.class;
	}

	@Override
	protected Class<? extends Button> getExpectedButtonClass() {
		return MacButton.class;
	}

	@Override
	protected String getExpectedCheckboxDisplay() {
		return MacCheckBox.DISPLAY;
	}

	@Override
	protected String getExpectedTextFieldDisplay() {
		return MacTextField.DISPLAY;
	}

	@Override
	protected String getExpectedDateFieldDisplay() {
		return MacDateField.DISPLAY;
	}

	@Override
	protected String getExpectedButtonDisplay() {
		return MacButton.DISPLAY;
	}

}
