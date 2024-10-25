/**
 * 
 */
package com.training.firshead.patterns.abstractfactory.mswindows;

import com.training.firshead.patterns.abstractfactory.CheckBox;


/**
 * @author vkulinsky
 * date: 10.01.2012
 * time: 23:44:43
 *
 */
public class MsWindowsCheckBox implements CheckBox {

	public static final String DISPLAY = "Ms Windows checkbox";
	
	public String getDisplay() {
		return DISPLAY;
	}

	public void setSelected(boolean selected) {
	}

	public boolean getSelected() {
		return false;
	}

}
