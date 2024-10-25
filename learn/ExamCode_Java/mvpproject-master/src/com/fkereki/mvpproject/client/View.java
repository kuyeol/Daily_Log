package com.fkereki.mvpproject.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author fkereki
 */
public abstract class View
    extends Composite {

  public final Widget asWidget() {
    return this;
  }
}
