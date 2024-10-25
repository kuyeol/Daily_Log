package com.fkereki.mvpproject.client.dummyOne;

import com.fkereki.mvpproject.client.Display;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.google.gwt.user.client.ui.PopupPanel;

public interface DummyOneDisplay
    extends Display {
  public void setPepeValue(String s);

  public PopupPanel getPopupPanel();

  public void showPopupPanel();

  public void setClickCallback(SimpleCallback<Object> scb);
}