/**
 * 
 */
package com.training.firshead.patterns.abstractfactory;

import junit.framework.TestCase;


/**
 * Generic control factory test <br>
 * Actually, this is an example of "abstract method" pattern:
 * the class encapculates all the common logic for testing control instantiating,
 * while concrete subclasses are responsible for instantiating concrete control factory
 * implementations. <br>
 * 
 * @author vkulinsky
 * date: 11.01.2012
 * time: 0:12:31
 *
 */
public abstract class GenericControlFactoryTest extends TestCase{
	
	private ControlFactory controlFactory;
	
	//asbtract method - responsible for creating concrete implementations of control factory
	protected abstract ControlFactory createControlFactory();
	
   protected abstract Class<? extends CheckBox>  getExpectedCheckboxClass();
   protected abstract Class<? extends TextField> getExpectedTextFieldClass();
   protected abstract Class<? extends DateField> getExpectedDateFieldClass();
   protected abstract Class<? extends Button>    getExpectedButtonClass();
   
   protected abstract String  getExpectedCheckboxDisplay(); 
   protected abstract String  getExpectedTextFieldDisplay();
   protected abstract String  getExpectedDateFieldDisplay();
   protected abstract String  getExpectedButtonDisplay();
	
	
	@Override
	protected void setUp() throws Exception {
		controlFactory = createControlFactory();
	}

	@Override
	protected void tearDown() throws Exception {
		controlFactory = null;
	}
	
	public void testCreateCheckBox() {
      CheckBox checkbox = controlFactory.createCheckBox();
		
		assertNotNull("Created checkbox must not be null", checkbox);
		assertEquals("Unexpected checkbox class",
				checkbox.getClass(), getExpectedCheckboxClass());
		assertEquals("Unexpected checkbox display", 
				checkbox.getDisplay(), getExpectedCheckboxDisplay());
	}
	
	
	public void testCreateTextField() {
      TextField textField = controlFactory.createTextField();
		
		assertNotNull("Created text field must not be null", textField);
		assertEquals("Unexpected text field class",
				textField.getClass(), getExpectedTextFieldClass());
		assertEquals("Unexpected text field display", 
				textField.getDisplay(), getExpectedTextFieldDisplay());
	}
	
	public void testCreateDateField() {
      DateField dateField = controlFactory.createDateField();
		
		assertNotNull("Created date field must not be null", dateField);
		assertEquals("Unexpected date field class",
				dateField.getClass(), getExpectedDateFieldClass());
		assertEquals("Unexpected text field display", 
				dateField.getDisplay(), getExpectedDateFieldDisplay());
	}
	
	public void testCreateButtonDateField() {
      Button button = controlFactory.createButton();
		
		assertNotNull("Created button must not be null", button);
		assertEquals("Unexpected button class",
				button.getClass(), getExpectedButtonClass());
		assertEquals("Unexpected text field display", 
				button.getDisplay(), getExpectedButtonDisplay());
	}

}
