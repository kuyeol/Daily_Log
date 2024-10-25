package com.fkereki.mvpproject.client;

import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.TextBox;

public class ReadOnlyTextBox2
    extends TextBox {

  /**
   * A simple textbox that just disables itself
   */
  public @UiConstructor
  ReadOnlyTextBox2(String init) {
    super();
    setEnabled(false);
    setValue(init);
  }
}
