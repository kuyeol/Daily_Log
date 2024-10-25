package com.fkereki.mvpproject.client.changePassword;

import com.fkereki.mvpproject.client.Display;
import com.fkereki.mvpproject.client.SimpleCallback;

public interface ChangePasswordFormDisplay
    extends Display {
  /**
   * Enable or disable the login button
   * 
   * @param b
   *          If true, enable the button; otherwise, disable it
   */
  void enableChangePasswordButton(boolean b);

  /**
   * Access the 1st Password field
   * 
   * @return Whatever the user entered in the 1st Password field
   */
  String getPassword1();

  /**
   * Access the 2nd Password field
   * 
   * @return Whatever the user entered in the 2nd Password field
   */
  String getPassword2();

  /**
   * Initialize the change password callback, which shall be executed when the
   * user clicks the "Change Password" button
   * 
   * @param acb
   *          Set the callback to acb. The Presenter will have to get the Name,
   *          Password1 and Password2 fields and perform the needed checks.
   */
  void setChangePasswordCallback(SimpleCallback<Object> acb);

  /**
   * Initialize the Name field
   * 
   * @param s
   *          Set the name field to s; most commonly just "" or possibly a saved
   *          name from an earlier session.
   */
  void setName(String s);

  /**
   * Initialize the password blur callback, which shall be executed when the
   * user changes the name textbox.
   * 
   * @param acb
   *          Set the password blur callback to acb.
   */
  void setPasswordBlurCallback(SimpleCallback<Object> acb);
}
