package com.fkereki.mvpproject.client.countryState;

import java.util.LinkedHashMap;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;

public class CountryStatePresenter
    extends Presenter<CountryStateDisplay> {

  public CountryStatePresenter(
      final String params,
      final CountryStateDisplay countryStateDisplay,
      final Environment environment) {

    super(params, countryStateDisplay, environment);

    /*
     * Display "Loading..." in lieu of the list of countries, at least until the
     * actual list comes from the server.
     */
    LinkedHashMap<String, String> emptyCountriesList = new LinkedHashMap<String, String>();
    emptyCountriesList.put("", "Loading...");
    getDisplay().setCountryList(emptyCountriesList);
    getEnvironment().getModel().getCountries(
        new SimpleCallback<LinkedHashMap<String, String>>() {
          @Override
          public void goBack(LinkedHashMap<String, String> result) {
            getDisplay().setCountryList(result);
          }
        });

    getDisplay().setOnCountryChangeCallback(
        new SimpleCallback<Object>() {
          @Override
          public void goBack(Object result) {
            getDisplay().setStateList(null);
            if (!getDisplay().getCountry().isEmpty()) {
              getEnvironment().getModel().getStates(
                  getDisplay().getCountry(),
                  new SimpleCallback<LinkedHashMap<String, String>>() {
                    @Override
                    public void goBack(
                        LinkedHashMap<String, String> result) {
                      getDisplay().setStateList(result);
                      ValueChangeEvent.fire(getDisplay(), null);
                    }
                  });
            }
          }
        });

    getDisplay().setOnStateChangeCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(Object result) {
        ValueChangeEvent.fire(getDisplay(), null);
      }
    });
  }
}
