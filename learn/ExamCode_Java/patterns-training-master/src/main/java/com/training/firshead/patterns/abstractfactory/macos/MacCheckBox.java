/**
 * 
 */
package com.training.firshead.patterns.abstractfactory.macos;

import com.training.firshead.patterns.abstractfactory.CheckBox;


/**
 * @author vkulinsky
 * date: 10.01.2012
 * time: 23:51:06
 *
 */
public class MacCheckBox implements CheckBox{

	public static final String DISPLAY = "Mac checkbox";
	
	public String getDisplay() {
		return DISPLAY;
	}

	public void setSelected(boolean selected) {
	}

	public boolean getSelected() {
		return false;
	}
	
}
