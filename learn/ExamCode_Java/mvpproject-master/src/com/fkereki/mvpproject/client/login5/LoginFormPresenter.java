package com.fkereki.mvpproject.client.login5;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;
import com.fkereki.mvpproject.client.Security;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.dtos.SessionKeyServiceReturnDto;
import com.fkereki.mvpproject.client.dtos.UserPassKeyDto;
import com.fkereki.mvpproject.client.rpc.LoginServiceAsync;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class LoginFormPresenter
    extends Presenter<LoginFormDisplay> {
  public static String PLACE = "login";

  LoginServiceAsync loginService;

  SimpleCallback<UserPassKeyDto> loginSuccessCallback;

  public LoginFormPresenter(
      final String params, final LoginFormDisplay loginDisplay,
      final Environment environment,
      final SimpleCallback<UserPassKeyDto> callback) {

    super(params, loginDisplay, environment);
    loginSuccessCallback = callback;
    loginService = getEnvironment().getModel().getRemoteLoginService();

    final SimpleCallback<Object> commonBlurHandler = new SimpleCallback<Object>() {
      @Override
      public void goBack(final Object result) {
        final String name = LoginFormPresenter.this.getDisplay()
            .getName();
        final String pass = LoginFormPresenter.this.getDisplay()
            .getPassword();
        final boolean canLogin = !name.isEmpty() & !pass.isEmpty();
        LoginFormPresenter.this.getDisplay()
            .enableLoginButton(canLogin);
      }
    };
    loginDisplay.setNameBlurCallback(commonBlurHandler);
    loginDisplay.setPasswordBlurCallback(commonBlurHandler);

    loginDisplay.setName("federico");
    loginDisplay.setPassword("");
    commonBlurHandler.goBack(null);

    loginDisplay.setLoginCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(final Object result) {
        LoginFormPresenter.this.getDisplay().enableLoginButton(false);

        final String name = LoginFormPresenter.this.getDisplay()
            .getName();
        final String pass = LoginFormPresenter.this.getDisplay()
            .getPassword();
        final String nonce = Security.randomCharString();
        final String hashPassword = Security.md5(nonce + pass);

        loginService.getSessionKey(name, nonce, hashPassword,
            new AsyncCallback<SessionKeyServiceReturnDto>() {
              @Override
              public void onFailure(final Throwable caught) {
                LoginFormPresenter.this.getEnvironment().showAlert(
                    "Failed login");
                LoginFormPresenter.this.getDisplay().enableLoginButton(
                    true);
                loginSuccessCallback.onFailure(new Throwable());
              }

              @Override
              public void onSuccess(
                  final SessionKeyServiceReturnDto result) {

                final String calculatedHash = Security.md5(nonce
                    + result.encryptedSessionKey);
                if (result.hash.equals(calculatedHash)) {
                  final Security secure = new Security();
                  final String sessionKey = secure
                      .codeDecode(
                          pass + nonce,
                          Security
                              .hexStringToByteString(result.encryptedSessionKey));

                  loginSuccessCallback.goBack(new UserPassKeyDto(name,
                      pass, sessionKey));
                } else {
                  LoginFormPresenter.this.getEnvironment().showAlert(
                      "Wrong data - problem in communication!");
                  LoginFormPresenter.this.getDisplay()
                      .enableLoginButton(true);
                  loginSuccessCallback.onFailure(new Throwable());
                }
              }
            });
      }
    });
  }
}
