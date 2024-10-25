package com.fkereki.mvpproject.client.rpc;

import com.fkereki.mvpproject.client.dtos.SessionKeyServiceReturnDto;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("login")
public interface LoginServiceAsync {

  void changePassword(
      String name,
      String encryptedNewPassword,
      String nonce,
      String parametersHash,
      AsyncCallback<Void> callback);

  void getSessionKey(
      String name,
      String nonce,
      String passHash,
      AsyncCallback<SessionKeyServiceReturnDto> callback);

  void getSomething(
      String name,
      String pass,
      AsyncCallback<String> callback);
}