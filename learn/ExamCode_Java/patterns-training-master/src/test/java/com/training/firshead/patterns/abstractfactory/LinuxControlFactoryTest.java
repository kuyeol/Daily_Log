/**
 * 
 */
package com.training.firshead.patterns.abstractfactory;

import com.training.firshead.patterns.abstractfactory.linux.LinuxButton;
import com.training.firshead.patterns.abstractfactory.linux.LinuxCheckBox;
import com.training.firshead.patterns.abstractfactory.linux.LinuxControlFactory;
import com.training.firshead.patterns.abstractfactory.linux.LinuxDateField;
import com.training.firshead.patterns.abstractfactory.linux.LinuxTextField;


/**
 * @author vkulinsky
 * date: 11.01.2012
 * time: 0:30:53
 *
 */
public class LinuxControlFactoryTest extends GenericControlFactoryTest{

	@Override
	protected ControlFactory createControlFactory() {
		return new LinuxControlFactory();
	}

	@Override
	protected Class<? extends CheckBox> getExpectedCheckboxClass() {
		return LinuxCheckBox.class;
	}

	@Override
	protected Class<? extends TextField> getExpectedTextFieldClass() {
		return LinuxTextField.class;
	}

	@Override
	protected Class<? extends DateField> getExpectedDateFieldClass() {
		return LinuxDateField.class;
	}

	@Override
	protected Class<? extends Button> getExpectedButtonClass() {
		return LinuxButton.class;
	}

	@Override
	protected String getExpectedCheckboxDisplay() {
		return LinuxCheckBox.DISPLAY;
	}

	@Override
	protected String getExpectedTextFieldDisplay() {
		return LinuxTextField.DISPLAY;
	}

	@Override
	protected String getExpectedDateFieldDisplay() {
		return LinuxDateField.DISPLAY;
	}

	@Override
	protected String getExpectedButtonDisplay() {
		return LinuxButton.DISPLAY;
	}

}
