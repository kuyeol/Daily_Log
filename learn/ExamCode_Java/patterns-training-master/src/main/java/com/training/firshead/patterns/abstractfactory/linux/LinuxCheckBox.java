/**
 * 
 */
package com.training.firshead.patterns.abstractfactory.linux;

import com.training.firshead.patterns.abstractfactory.CheckBox;


/**
 * @author vkulinsky
 * date: 10.01.2012
 * time: 23:58:03
 *
 */
public class LinuxCheckBox implements CheckBox{
	
	public static final String DISPLAY = "Linux checkbox";

	public String getDisplay() {
		return DISPLAY;
	}

	public void setSelected(boolean selected) {
	}

	public boolean getSelected() {
		return false;
	}

}
