package com.fkereki.mvpproject.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fkereki.mvpproject.client.dtos.SessionKeyServiceReturnDto;
import com.fkereki.mvpproject.client.exceptions.FailedLoginException;
import com.fkereki.mvpproject.client.exceptions.PasswordNotChangedException;
import com.fkereki.mvpproject.client.rpc.LoginService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class LoginServiceImpl
    extends RemoteServiceServlet
    implements LoginService {

  private static String SESSION_KEY_ID = "sessionkey";

  @Override
  public void changePassword(
      final String name,
      final String encryptedNewPassword,
      final String nonce,
      final String parametersHash)
      throws PasswordNotChangedException {

    // get the session key for the given user name
    // (alternative: get it from the DB)
    final HttpServletRequest request = getThreadLocalRequest();
    final HttpSession session = request.getSession();
    final String sessionKey = (String) session
        .getAttribute(SESSION_KEY_ID);

    // get the user password from the session
    final String password = "kereki";

    // check whether parametersHash matches
    // hash(nonce+encryptedNewPassword+sessionKey)

    final String calculatedHash = Security.md5(nonce
        + encryptedNewPassword + sessionKey);

    if (calculatedHash.equals(parametersHash)) {

      // if so, decrypt encryptedNewPassword with nonce+password+sessionKey
      // store the new password at the DB
      final String encryptedPass = Security
          .hexStringToByteString(encryptedNewPassword);
      final Security sc = new Security();
      final String unencryptedPassword = sc.codeDecode(nonce + password
          + sessionKey, encryptedPass);

      // save password in DB
    } else {
      // raise Exception
      throw new PasswordNotChangedException();
    }
  }

  @Override
  public SessionKeyServiceReturnDto getSessionKey(
      final String name,
      final String nonce,
      final String passHash)
      throws FailedLoginException {

    // get the password from the DB, not as here!
    final String password = "kereki";

    // check the received data by means of the hash
    final String calculatedHash = Security.md5(nonce + password);

    // if there's a match, create a sessionKey and send it back
    if (passHash.equals(calculatedHash)) {
      final String sessionKey = Security.randomCharString()
          .toLowerCase();

      // store the session key from the session
      // (alternative: store the key at the DB)
      final HttpServletRequest request = getThreadLocalRequest();
      final HttpSession session = request.getSession();
      session.setAttribute(SESSION_KEY_ID, sessionKey);

      final Security secure = new Security();
      final String coded = secure.codeDecode(password + nonce,
          sessionKey);
      final String hexCoded = Security.byteStringToHexString(coded);

      final SessionKeyServiceReturnDto sk = new SessionKeyServiceReturnDto();
      sk.encryptedSessionKey = hexCoded;
      sk.hash = Security.md5(nonce + hexCoded);

      return sk;
    } else {
      throw new FailedLoginException();
    }
  }

  @Override
  public String getSomething(final String name, final String pass) {
    return name + " " + pass; // not useful; this is just a placeholder...
  }
}
