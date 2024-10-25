package com.fkereki.mvpproject.client.changePassword;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;
import com.fkereki.mvpproject.client.Security;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.rpc.LoginServiceAsync;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ChangePasswordFormPresenter
    extends Presenter<ChangePasswordFormDisplay> {
  public static String PLACE = "change";

  LoginServiceAsync loginService;

  SimpleCallback<String> loginSuccessCallback;

  public ChangePasswordFormPresenter(
      final String params,
      final ChangePasswordFormDisplay loginDisplay,
      final Environment environment) {

    super(params, loginDisplay, environment);
    loginService = getEnvironment().getModel().getRemoteLoginService();

    final SimpleCallback<Object> commonBlurHandler = new SimpleCallback<Object>() {
      @Override
      public void goBack(final Object result) {
        final String pass1 = ChangePasswordFormPresenter.this
            .getDisplay().getPassword1();
        final String pass2 = ChangePasswordFormPresenter.this
            .getDisplay().getPassword2();
        final boolean canLogin = !pass1.isEmpty() & pass1.equals(pass2);
        ChangePasswordFormPresenter.this.getDisplay()
            .enableChangePasswordButton(canLogin);
      }
    };
    loginDisplay.setPasswordBlurCallback(commonBlurHandler);

    final String currentUser = environment.getCurrentUserName();
    final String currentKey = environment.getCurrentSessionKey();
    final String currentPass = environment.getCurrentUserPassword();

    loginDisplay.setName(currentUser);

    // get the session key for the given user name
    // get the user password from the DB
    // check whether parametersHash matches
    // hash(nonce+encryptedNewPassword+sessionKey)
    // if so, decrypt encryptedNewPassword with nonce+password+sessionKey
    // store the new password at the DB

    commonBlurHandler.goBack(null);

    loginDisplay
        .setChangePasswordCallback(new SimpleCallback<Object>() {
          @Override
          public void goBack(final Object result) {
            ChangePasswordFormPresenter.this.getDisplay()
                .enableChangePasswordButton(false);

            final String pass1 = ChangePasswordFormPresenter.this
                .getDisplay().getPassword1();

            final Security sc = new Security();
            final String nonce = Security.randomCharString();

            final String encryptedPass1 = sc.codeDecode(nonce
                + currentPass + currentKey, pass1);

            final String visibleEncryptedPass1 = Security
                .byteStringToHexString(encryptedPass1);

            final String hashPassword = Security.md5(nonce
                + visibleEncryptedPass1
                + environment.getCurrentSessionKey());

            loginService.changePassword(currentUser,
                visibleEncryptedPass1, nonce, hashPassword,
                new AsyncCallback<Void>() {
                  @Override
                  public void onFailure(final Throwable caught) {
                    ChangePasswordFormPresenter.this.getEnvironment()
                        .showAlert("Failed change");

                    ChangePasswordFormPresenter.this.getDisplay()
                        .enableChangePasswordButton(true);
                  }

                  public void onSuccess(final Void result) {
                    ChangePasswordFormPresenter.this.getEnvironment()
                        .showAlert("Password was changed");

                    ChangePasswordFormPresenter.this.getEnvironment()
                        .setCurrentUserPassword(pass1);

                    ChangePasswordFormPresenter.this.getDisplay()
                        .enableChangePasswordButton(true);
                  }
                });
          }
        });
  }
}
