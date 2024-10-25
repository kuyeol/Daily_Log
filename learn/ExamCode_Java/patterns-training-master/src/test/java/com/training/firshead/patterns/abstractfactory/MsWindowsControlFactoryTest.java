/**
 * 
 */
package com.training.firshead.patterns.abstractfactory;

import com.training.firshead.patterns.abstractfactory.mswindows.MsWindowsButton;
import com.training.firshead.patterns.abstractfactory.mswindows.MsWindowsCheckBox;
import com.training.firshead.patterns.abstractfactory.mswindows.MsWindowsControlFactory;
import com.training.firshead.patterns.abstractfactory.mswindows.MsWindowsDateField;
import com.training.firshead.patterns.abstractfactory.mswindows.MsWindowsTextField;

/**
 * @author vkulinsky
 *         date: 11.01.2012
 *         time: 0:07:53
 * 
 */
public class MsWindowsControlFactoryTest extends GenericControlFactoryTest {

	@Override
	protected ControlFactory createControlFactory() {
		return new MsWindowsControlFactory();
	}

	@Override
	protected Class<? extends CheckBox> getExpectedCheckboxClass() {
		return MsWindowsCheckBox.class;
	}

	@Override
	protected Class<? extends TextField> getExpectedTextFieldClass() {
		return MsWindowsTextField.class;
	}

	@Override
	protected Class<? extends DateField> getExpectedDateFieldClass() {
		return MsWindowsDateField.class;
	}

	@Override
	protected Class<? extends Button> getExpectedButtonClass() {
		return MsWindowsButton.class;
	}

	@Override
	protected String getExpectedCheckboxDisplay() {
		return MsWindowsCheckBox.DISPLAY;
	}

	@Override
	protected String getExpectedTextFieldDisplay() {
		return MsWindowsTextField.DISPLAY;
	}

	@Override
	protected String getExpectedDateFieldDisplay() {
		return MsWindowsDateField.DISPLAY;
	}

	@Override
	protected String getExpectedButtonDisplay() {
		return MsWindowsButton.DISPLAY;
	}

}
