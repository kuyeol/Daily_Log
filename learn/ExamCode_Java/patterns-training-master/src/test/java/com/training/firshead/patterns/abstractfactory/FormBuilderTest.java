/**
 * 
 */
package com.training.firshead.patterns.abstractfactory;

import junit.framework.TestCase;

import com.training.firshead.patterns.abstractfactory.linux.LinuxButton;
import com.training.firshead.patterns.abstractfactory.linux.LinuxCheckBox;
import com.training.firshead.patterns.abstractfactory.linux.LinuxControlFactory;
import com.training.firshead.patterns.abstractfactory.linux.LinuxDateField;
import com.training.firshead.patterns.abstractfactory.linux.LinuxTextField;
import com.training.firshead.patterns.abstractfactory.macos.MacButton;
import com.training.firshead.patterns.abstractfactory.macos.MacCheckBox;
import com.training.firshead.patterns.abstractfactory.macos.MacControlFactory;
import com.training.firshead.patterns.abstractfactory.macos.MacDateField;
import com.training.firshead.patterns.abstractfactory.macos.MacTextField;
import com.training.firshead.patterns.abstractfactory.mswindows.MsWindowsButton;
import com.training.firshead.patterns.abstractfactory.mswindows.MsWindowsCheckBox;
import com.training.firshead.patterns.abstractfactory.mswindows.MsWindowsControlFactory;
import com.training.firshead.patterns.abstractfactory.mswindows.MsWindowsDateField;
import com.training.firshead.patterns.abstractfactory.mswindows.MsWindowsTextField;


/**
 * From "abstract factory" point of view this class is a client 
 * (it's responsible for configuring which control factory is actually should be used in application).
 * 
 * @author vkulinsky
 * date: 11.01.2012
 * time: 0:33:47
 *
 */
public class FormBuilderTest extends TestCase{
	
	public void testFormCreate() {
		
		String expectedFormDisplay = 
				MsWindowsCheckBox.DISPLAY + Form.CONTROL_DELIMITER +
				MsWindowsTextField.DISPLAY + Form.CONTROL_DELIMITER +
				MsWindowsDateField.DISPLAY + Form.CONTROL_DELIMITER +
				MsWindowsButton.DISPLAY;
		checkForm("ms windows", new MsWindowsControlFactory(), expectedFormDisplay);
		
		expectedFormDisplay = 
				MacCheckBox.DISPLAY + Form.CONTROL_DELIMITER +
				MacTextField.DISPLAY + Form.CONTROL_DELIMITER +
				MacDateField.DISPLAY + Form.CONTROL_DELIMITER +
				MacButton.DISPLAY;
		checkForm("mac", new MacControlFactory(), expectedFormDisplay);
		
		expectedFormDisplay = 
				LinuxCheckBox.DISPLAY + Form.CONTROL_DELIMITER +
				LinuxTextField.DISPLAY + Form.CONTROL_DELIMITER +
				LinuxDateField.DISPLAY + Form.CONTROL_DELIMITER +
				LinuxButton.DISPLAY;
		checkForm("linux", new LinuxControlFactory(), expectedFormDisplay);
	}
	
	private void checkForm(String testPrefix, ControlFactory controlFactory, String formDisplay) {
		FormBuilder formBuilder =  new FormBuilder(controlFactory);
		Form form = formBuilder.createForm();
		
		assertNotNull(testPrefix+": Created form must not be null", form);
		assertEquals(testPrefix+": Unexpected form display", form.getDisplay(), formDisplay);
	}
	
}
