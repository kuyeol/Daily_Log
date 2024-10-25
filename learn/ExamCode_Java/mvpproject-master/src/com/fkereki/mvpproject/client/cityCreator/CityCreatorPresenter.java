package com.fkereki.mvpproject.client.cityCreator;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.countryState.CountryStatePresenter;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class CityCreatorPresenter
    extends Presenter<CityCreatorDisplay> {
  public static String PLACE = "citycreate";

  CountryStatePresenter csp;

  public CityCreatorPresenter(
      final String params, final CityCreatorDisplay cityCreatorDisplay,
      final Environment environment) {

    super(params, cityCreatorDisplay, environment);

    csp = new CountryStatePresenter("", getDisplay().getCountryState(),
        environment);

    getDisplay().setOnAddClickCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(Object result) {
        Window.alert("clickety!");
      }
    });

    SimpleCallback<Object> ch = new SimpleCallback<Object>() {
      @Override
      public void goBack(Object result) {
        final String country = getDisplay().getCountryState()
            .getCountry();
        final String state = getDisplay().getCountryState().getState();
        final String city = getDisplay().getCityName();

        if (!country.isEmpty() && !state.isEmpty() && !city.isEmpty()) {

          getEnvironment().getModel().getRemoteWorldService()
              .cityExists(country, state, city,
                  new AsyncCallback<Boolean>() {

                    public void onFailure(final Throwable caught) {
                      Window.alert("Failure checking city: "
                          + caught.getMessage());
                    }

                    public void onSuccess(final Boolean result) {
                      if (result.booleanValue()) {
                        /*
                         * That city already exists!
                         */
                        getEnvironment().showAlert(
                            "That city is already in the database");
                        getDisplay().setCityNameCssStyle(
                            "gwt-Textbox-Error");
                      } else {
                        getDisplay().setCityNameCssStyle("gwt-TextBox");
                      }
                    }
                  });
        }
      }
    };

    getDisplay().setOnCityNameChangeCallback(ch);
    getDisplay().setOnCountryStateChangeCallback(ch);
  }
}