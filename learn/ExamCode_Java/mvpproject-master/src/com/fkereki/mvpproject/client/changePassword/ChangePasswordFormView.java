package com.fkereki.mvpproject.client.changePassword;

import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Defines a Login Form.
 */
public class ChangePasswordFormView
    extends View
    implements ChangePasswordFormDisplay {

  @UiTemplate("ChangePasswordFormView.ui.xml")
  interface Binder
      extends UiBinder<HTMLPanel, ChangePasswordFormView> {
  }

  AsyncCallback<Object> changePasswordCallback;
  AsyncCallback<Object> passwordBlurCallback;

  @UiField
  TextBox nameTextBox;

  @UiField
  PasswordTextBox passwordTextBox1;

  @UiField
  PasswordTextBox passwordTextBox2;

  @UiField
  Button changePasswordButton;

  private static final Binder binder = GWT.create(Binder.class);

  public ChangePasswordFormView() {
    final HTMLPanel dlp = binder.createAndBindUi(this);
    initWidget(dlp);
  }

  @Override
  public void enableChangePasswordButton(final boolean b) {
    changePasswordButton.setEnabled(b);
  }

  @Override
  public final String getPassword1() {
    return passwordTextBox1.getValue();
  }

  @Override
  public final String getPassword2() {
    return passwordTextBox2.getValue();
  }

  @Override
  public final void setChangePasswordCallback(
      final SimpleCallback<Object> acb) {
    changePasswordCallback = acb;
  }

  @Override
  public void setName(final String s) {
    nameTextBox.setValue(s);
  }

  @Override
  public void setPasswordBlurCallback(final SimpleCallback<Object> acb) {
    passwordBlurCallback = acb;
  }

  @UiHandler("passwordTextBox1")
  void uiOnBlurPassword1(final BlurEvent event) {
    passwordBlurCallback.onSuccess(null);
  }

  @UiHandler("passwordTextBox2")
  void uiOnBlurPassword2(final BlurEvent event) {
    passwordBlurCallback.onSuccess(null);
  }

  @UiHandler("changePasswordButton")
  void uiOnChangePasswordButton(final ClickEvent event) {
    changePasswordCallback.onSuccess(null);
  }
}
