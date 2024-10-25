package com.fkereki.mvpproject.client;

import com.fkereki.mvpproject.client.login.LoginFormPresenter;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;

public class Mvpproject
    implements EntryPoint, ValueChangeHandler<String> {

  public static native String getUserAgent() /*-{
    return navigator.userAgent.toLowerCase();
  }-*/;

  Environment environment;

  public void onModuleLoad() {
    DOM.removeChild(RootPanel.getBodyElement(), DOM
        .getElementById("loading"));

    environment = new Environment(new Model(), History.getToken());

    /*
     * Set up the history management, and start by showing the login form.
     */
    History.addValueChangeHandler(this);
    environment.launch(LoginFormPresenter.PLACE);
  }

  @Override
  public void onValueChange(final ValueChangeEvent<String> event) {
    environment.launch(event.getValue());
  }
}