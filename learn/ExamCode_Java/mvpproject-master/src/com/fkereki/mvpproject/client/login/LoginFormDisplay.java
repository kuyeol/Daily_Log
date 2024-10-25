package com.fkereki.mvpproject.client.login;

import com.fkereki.mvpproject.client.Display;
import com.fkereki.mvpproject.client.SimpleCallback;

public interface LoginFormDisplay
    extends Display {
  /**
   * Access the Name field
   * 
   * @return Whatever the user entered in the Name field
   */
  String getName();

  /**
   * Initialize the Name field
   * 
   * @param s
   *          Set the name field to s; most commonly just "" or possibly a saved
   *          name from an earlier session.
   */
  void setName(String s);

  /**
   * Access the Password field
   * 
   * @return Whatever the user entered in the Password field
   */
  String getPassword();

  /**
   * Initialize the Password field
   * 
   * @param s
   *          Set the password field to s; usually just ""
   */
  void setPassword(String s);

  /**
   * Initialize the login callback, which shall be executed when the user clicks
   * the "Login" button
   * 
   * @param acb
   *          Set the login callback to acb. The Presenter will have to get the
   *          Name and Password fields (by using the methods above) and perform
   *          the needed checks.
   */
  void setLoginCallback(SimpleCallback<Object> acb);
}
