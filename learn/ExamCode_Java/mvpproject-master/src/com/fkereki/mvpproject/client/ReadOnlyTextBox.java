package com.fkereki.mvpproject.client;

import com.google.gwt.user.client.ui.TextBox;

public class ReadOnlyTextBox
    extends TextBox {

  /**
   * A simple textbox that just disables itself
   */
  public ReadOnlyTextBox() {
    super();
    setEnabled(false);
  }
}
