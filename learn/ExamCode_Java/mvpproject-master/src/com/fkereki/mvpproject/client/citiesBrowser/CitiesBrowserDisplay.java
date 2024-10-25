/**
 * 
 */
package com.fkereki.mvpproject.client.citiesBrowser;

import java.util.LinkedHashMap;

import com.fkereki.mvpproject.client.Display;
import com.fkereki.mvpproject.client.SimpleCallback;

/**
 * @author fkereki
 */
public interface CitiesBrowserDisplay
    extends Display {
  String getCountry();

  String getState();

  void setCityData(
      final int i,
      final String name,
      final String pop,
      final String lat,
      final String lon);

  void setCountryList(LinkedHashMap<String, String> cl);

  void setOnCountryChangeCallback(SimpleCallback<Object> acb);

  void setOnFirstClickCallback(SimpleCallback<Object> acb);

  void setOnNextClickCallback(SimpleCallback<Object> acb);

  void setOnPreviousClickCallback(SimpleCallback<Object> acb);

  void setOnStateChangeCallback(SimpleCallback<Object> acb);

  void setStateList(LinkedHashMap<String, String> sl);
}
