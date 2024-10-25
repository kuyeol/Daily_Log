/**
 * 
 */
package com.training.firshead.patterns.abstractfactory;


/**
 * The class represents a simple form that contains
 * <ul>
 *  <li> single check box
 *  <li> single text field
 *  <li> single date field
 *  <li> single button
 * </ul>
 * 
 * @author vkulinsky
 * date: 10.01.2012
 * time: 23:32:50
 *
 */
public class Form implements Control{
	
	public static final String CONTROL_DELIMITER = "||";
	
	private CheckBox checkBox;
	private TextField textField;
	private DateField dateField;
	private Button button;
	
	/**
	 * @return the checkBox
	 */
	public CheckBox getCheckBox() {
		return checkBox;
	}
	
	/**
	 * @param checkBox the checkBox to set
	 */
	public void setCheckBox(CheckBox checkBox) {
		this.checkBox = checkBox;
	}
	
	/**
	 * @return the textField
	 */
	public TextField getTextField() {
		return textField;
	}
	
	/**
	 * @param textField the textField to set
	 */
	public void setTextField(TextField textField) {
		this.textField = textField;
	}
	
	/**
	 * @return the dateField
	 */
	public DateField getDateField() {
		return dateField;
	}
	
	/**
	 * @param dateField the dateField to set
	 */
	public void setDateField(DateField dateField) {
		this.dateField = dateField;
	}
	
	/**
	 * @return the button
	 */
	public Button getButton() {
		return button;
	}
	
	/**
	 * @param button the button to set
	 */
	public void setButton(Button button) {
		this.button = button;
	}

	public String getDisplay() {
		return checkBox.getDisplay() + CONTROL_DELIMITER +
				textField.getDisplay() + CONTROL_DELIMITER +
				dateField.getDisplay() + CONTROL_DELIMITER +
				button.getDisplay() ;
	}
	
}
