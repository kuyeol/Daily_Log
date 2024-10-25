package com.fkereki.mvpproject.client.i18n;

import com.google.gwt.i18n.client.ConstantsWithLookup;

public interface Greeter
    extends ConstantsWithLookup {

  @Key("day.afternoon")
  @DefaultStringValue("afternoon")
  String afternoon();

  String genericHello();

  @DefaultStringValue("English speakers")
  String kindOfUsers();

  @Key("day.morning")
  @DefaultStringValue("morning")
  String morning();

  String specificQuery();
}
