/**
 * 
 */
package com.training.firshead.patterns.abstractfactory;


/**
 * The class if responsible for constructing form. <br>
 * Please, note that implementation doesn't linked to any concreted implementations of control,
 * it's just uses control factory to create corresponding controls. 
 * 
 * 
 * @author vkulinsky
 * date: 10.01.2012
 * time: 23:39:50
 *
 */
public class FormBuilder {

	private Form form;
	private ControlFactory controlFactory;
	
	
	/**
	 * @param controlFactory
	 */
	public FormBuilder(ControlFactory controlFactory) {
		super();
		this.controlFactory = controlFactory;
	}
	
	
	public Form createForm() {
		form = new Form();
		form.setCheckBox(controlFactory.createCheckBox());
		form.setTextField(controlFactory.createTextField());
		form.setDateField(controlFactory.createDateField());
		form.setButton(controlFactory.createButton());
		return form;
	}
	
}
