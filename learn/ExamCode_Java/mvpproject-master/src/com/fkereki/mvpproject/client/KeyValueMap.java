package com.fkereki.mvpproject.client;

import java.util.HashMap;

/**
 * KeyValueMap: a short way of specifying a class that will be used to pass
 * parameters to forms.
 * 
 * @author fkereki
 */
public class KeyValueMap
    extends HashMap<String, String> {
  private static final long serialVersionUID = 5225712868559413562L;

  /**
   * Standard constructor; produces an empty KeyValueMap.
   */
  public KeyValueMap() {
    this("");
  }

  /**
   * Create a KeyValueMap, and initialize it with the params string.
   * 
   * @param params
   *          A string with URL-like parameters (see below)
   */
  public KeyValueMap(final String params) {
    initializeWithString(params);
  }

  /**
   * Initialize a KeyValueMap with a parameters URL-like string.
   * 
   * @param params
   *          A string formatted like param1=value1&param2=value2&... It is
   *          assumed that the value has been appropriately escaped.
   */
  public final void initializeWithString(final String params) {
    clear();
    if ((params != null) && !params.isEmpty()) {
      String[] args = params.split("&");
      for (String element : args) {
        int equalIndex = element.indexOf("=");
        if (equalIndex == -1) {
          put(element, "");
        } else {
          put(element.substring(0, equalIndex), element
              .substring(equalIndex + 1));
        }
      }
    }
  }

  @Override
  public String toString() {
    String result = "";
    String separator = "";
    for (String key : keySet()) {
      result += separator + key + "=" + get(key);
      separator = "\n";
    }
    return result;
  }
}
