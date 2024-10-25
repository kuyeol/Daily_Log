package com.fkereki.mvpproject.client.citiesBrowser;

import java.util.LinkedHashMap;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.rpc.ClientCityData;
import com.google.gwt.i18n.client.NumberFormat;

public class CitiesBrowserPresenter
    extends Presenter<CitiesBrowserDisplay> {
  public static String PLACE = "citybrowse";

  int currentStart = 0;

  public CitiesBrowserPresenter(
      final String params,
      final CitiesBrowserDisplay citiesBrowserDisplay,
      final Environment environment) {

    super(params, citiesBrowserDisplay, environment);

    clearCities();

    getDisplay().setOnFirstClickCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(Object result) {
        if (checkCountryAndState()) {
          currentStart = 0;
          getAndDisplayCities();
        }
      }
    });

    getDisplay().setOnPreviousClickCallback(
        new SimpleCallback<Object>() {
          @Override
          public void goBack(Object result) {
            if (checkCountryAndState()) {
              currentStart -= CitiesBrowserView.CITIES_PAGE_SIZE;
              getAndDisplayCities();
            }
          }
        });

    getDisplay().setOnNextClickCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(Object result) {
        if (checkCountryAndState()) {
          currentStart += CitiesBrowserView.CITIES_PAGE_SIZE;
          getAndDisplayCities();
        }
      }
    });

    getDisplay().setOnCountryChangeCallback(
        new SimpleCallback<Object>() {
          @Override
          public void goBack(Object result) {
            /*
             * Clear the grid and the states listbox
             */
            clearCities();
            getDisplay().setStateList(null);

            /*
             * If a country was selected, get and load its states
             */
            if (!getDisplay().getCountry().isEmpty()) {
              getEnvironment().getModel().getStates(
                  getDisplay().getCountry(),
                  new SimpleCallback<LinkedHashMap<String, String>>() {
                    @Override
                    public void goBack(
                        LinkedHashMap<String, String> result) {
                      getDisplay().setStateList(result);
                    }
                  });
            }
          }
        });

    getDisplay().setOnStateChangeCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(Object result) {
        clearCities();
      }
    });

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
  }

  boolean checkCountryAndState() {
    return !getDisplay().getCountry().isEmpty()
        && !getDisplay().getState().isEmpty();
  }

  void clearCities() {
    currentStart = 0;
    displayEmptyCities(0, "");
  }

  /**
   * Display all cities in citiesList in the grid. If there aren't enough cities
   * to fill out the grid, empty the extra rows.
   * 
   * @param pCitiesList
   *          Hash map ordered alphabetically by city name, with up to
   *          CITIES_PAGE_SIZE cities.
   */
  void displayCities(
      final LinkedHashMap<String, ClientCityData> pCitiesList) {
    final NumberFormat nf = NumberFormat.getDecimalFormat();

    int i = 0;
    for (final String it : pCitiesList.keySet()) {
      i++;
      final ClientCityData cd = pCitiesList.get(it);
      getDisplay().setCityData(i, cd.cityName,
          nf.format(cd.population), nf.format(cd.latitude),
          nf.format(cd.longitude));
    }

    displayEmptyCities(i, "");
  }

  /**
   * Blank out all lines in the cities grid, from the line pSince up to the end.
   * 
   * @param pSince
   *          First line to blank
   * @param pDisplayText
   *          Text to display in the first column; may be "Loading..." or ""
   */
  void displayEmptyCities(int pSince, final String pDisplayText) {
    while (pSince < CitiesBrowserView.CITIES_PAGE_SIZE) {
      pSince++;
      getDisplay().setCityData(pSince, pDisplayText, "", "", "");
    }
  }

  void getAndDisplayCities() {
    if (currentStart < 0) {
      currentStart = 0;
    }

    displayEmptyCities(0, "Loading...");
    getEnvironment().getModel().getCities(getDisplay().getCountry(),
        getDisplay().getState(), currentStart,
        CitiesBrowserView.CITIES_PAGE_SIZE,
        new SimpleCallback<LinkedHashMap<String, ClientCityData>>() {
          @Override
          public void goBack(
              LinkedHashMap<String, ClientCityData> result) {
            displayCities(result);
          }
        });

  }
}