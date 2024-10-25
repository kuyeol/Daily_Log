package com.fkereki.mvpproject.client.rpc;

import com.fkereki.mvpproject.client.dtos.SessionKeyServiceReturnDto;
import com.fkereki.mvpproject.client.exceptions.FailedLoginException;
import com.fkereki.mvpproject.client.exceptions.PasswordNotChangedException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("login")
public interface LoginService
    extends RemoteService {
  void changePassword(
      String name,
      String encryptedNewPassword,
      String nonce,
      String parametersHash)
      throws PasswordNotChangedException;

  SessionKeyServiceReturnDto getSessionKey(
      String name,
      String nonce,
      String passHash)
      throws FailedLoginException;

  String getSomething(String name, String pass);
}