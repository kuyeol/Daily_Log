package com.fkereki.mvpproject.client.login5;

import com.fkereki.mvpproject.client.ReadOnlyTextBox2;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Defines a Login Form.
 */
public class LoginFormView
    extends View
    implements LoginFormDisplay {
  @UiTemplate("LoginFormView.ui.xml")
  interface Binder
      extends UiBinder<HTMLPanel, LoginFormView> {
  }

  AsyncCallback<Object> loginCallback;
  AsyncCallback<Object> nameBlurCallback;
  AsyncCallback<Object> passwordBlurCallback;

  @UiField
  TextBox nameTextBox;
  @UiField
  PasswordTextBox passwordTextBox;
  @UiField(provided = true)
  Button loginButton;

  private static final Binder binder = GWT.create(Binder.class);

  public LoginFormView() {
    loginButton = new Button("Ok");
    final HTMLPanel dlp = binder.createAndBindUi(this);
    initWidget(dlp);

    DOM
        .setElementAttribute(loginButton.getElement(), "id",
            "my_own_id");
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

  @UiFactory
  ReadOnlyTextBox2 makeROTB(final String init) {
    return new ReadOnlyTextBox2(init);
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

  @UiHandler("nameTextBox")
  void uiOnBlurName(final BlurEvent event) {
    nameBlurCallback.onSuccess(null);
  }

  @UiHandler("passwordTextBox")
  void uiOnBlurPassword(final BlurEvent event) {
    passwordBlurCallback.onSuccess(null);
  }

  @UiHandler("loginButton")
  void uiOnLoginButton(final ClickEvent event) {
    loginCallback.onSuccess(null);
  }
}
