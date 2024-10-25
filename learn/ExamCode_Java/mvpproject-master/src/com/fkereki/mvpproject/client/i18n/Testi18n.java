package com.fkereki.mvpproject.client.i18n;

import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Testi18n
    implements EntryPoint {

  @Override
  public void onModuleLoad() {
    final DateTimeFormat format1 = DateTimeFormat.getShortDateFormat();
    final String date = format1.format(new Date());

    final DateTimeFormat format2 = DateTimeFormat.getShortTimeFormat();
    final String time = format2.format(new Date());
    Window.alert("Date:" + date + " time:" + time);

    // final Greeter greet = GWT.create(Greeter.class);
    //
    // Window.alert(greet.genericHello() + " " + greet.specificQuery());
    //
    // Window.alert(greet.kindOfUsers());
    // Window.alert(greet.getString("kindOfUsers"));
    //
    // final MyMessages myme = GWT.create(MyMessages.class);
    //
    // Window.alert(myme.sayGoodbye("Mr Chips"));
    //
    // Window.alert(myme.sayAge2(1960, 49));
    // Window.alert(myme.sayAge2(2008, 1));
    //
    // Window.alert(myme.howMany(0) + "/" + myme.howMany(1) + "/"
    // + myme.howMany(2) + "/" + myme.howMany(3));
  }
}
