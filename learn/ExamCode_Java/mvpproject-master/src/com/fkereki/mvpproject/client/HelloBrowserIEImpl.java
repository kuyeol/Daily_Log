package com.fkereki.mvpproject.client;

import com.google.gwt.user.client.Window;

public class HelloBrowserIEImpl extends HelloBrowserStdImpl {
  @Override
  public void sayHello() {
    Window.alert("If you are seeing this, you have IE");
  }
}
