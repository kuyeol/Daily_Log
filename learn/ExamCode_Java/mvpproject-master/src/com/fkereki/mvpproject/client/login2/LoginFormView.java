package com.fkereki.mvpproject.client.login2;

import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.View;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Defines a Login Form.
 */
public class LoginFormView
    extends View
    implements LoginFormDisplay {

  AsyncCallback<Object> loginCallback;
  AsyncCallback<Object> nameBlurCallback;
  AsyncCallback<Object> passwordBlurCallback;

  final TextBox nameTextBox = new TextBox();
  final TextBox passwordTextBox = new PasswordTextBox();
  final Button loginButton = new Button("Log in");
  final FlexTable flex = new FlexTable();
  final DockPanel dock = new DockPanel();

  /**
   * Defines the view for the Login Form. Since this will be shown in the main
   * screen, we take care of centering the fields (by using a DockPanel) so it
   * will look nicer.
   */
  public LoginFormView() {
    loginButton.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(final ClickEvent event) {
        loginCallback.onSuccess(null);
      }
    });

    nameTextBox.addBlurHandler(new BlurHandler() {
      @Override
      public void onBlur(final BlurEvent event) {
        nameBlurCallback.onSuccess(null);
      }
    });

    passwordTextBox.addBlurHandler(new BlurHandler() {
      @Override
      public void onBlur(final BlurEvent event) {
        passwordBlurCallback.onSuccess(null);
      }
    });

    flex.setWidget(0, 0, new Label("User name:"));
    flex.setWidget(0, 1, nameTextBox);
    flex.setWidget(1, 0, new Label("Password:"));
    flex.setWidget(1, 1, passwordTextBox);
    flex.setWidget(2, 1, loginButton);

    dock.setWidth("100%");
    dock.setHeight("100%");
    dock.setHorizontalAlignment(DockPanel.ALIGN_CENTER);
    dock.setVerticalAlignment(DockPanel.ALIGN_MIDDLE);
    dock.add(flex, DockPanel.CENTER);

    initWidget(dock);
  }

  @Override
  public void enableLoginButton(final boolean b) {
    loginButton.setEnabled(b);
  }

  @Override
  public final String getName() {
    return nameTextBox.getValue();
  }

  @Override
  public final String getPassword() {
    return passwordTextBox.getValue();
  }

  @Override
  public final void setLoginCallback(final SimpleCallback<Object> acb) {
    loginCallback = acb;
  }

  @Override
  public final void setName(final String s) {
    nameTextBox.setValue(s);
  }

  @Override
  public void setNameBlurCallback(final SimpleCallback<Object> acb) {
    nameBlurCallback = acb;
  }

  @Override
  public final void setPassword(final String s) {
    passwordTextBox.setValue(s);
  }

  @Override
  public void setPasswordBlurCallback(final SimpleCallback<Object> acb) {
    passwordBlurCallback = acb;
  }
}
