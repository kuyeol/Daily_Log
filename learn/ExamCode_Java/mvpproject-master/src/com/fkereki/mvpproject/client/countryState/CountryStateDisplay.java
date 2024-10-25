package com.fkereki.mvpproject.client.countryState;

import java.util.LinkedHashMap;

import com.fkereki.mvpproject.client.Display;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;

public interface CountryStateDisplay
    extends Display, HasValueChangeHandlers<Object> {

  String getCountry();

  String getState();

  void setCountryList(LinkedHashMap<String, String> cl);

  void setOnCountryChangeCallback(SimpleCallback<Object> acb);

  void setOnStateChangeCallback(SimpleCallback<Object> acb);

  void setStateList(LinkedHashMap<String, String> sl);
}
