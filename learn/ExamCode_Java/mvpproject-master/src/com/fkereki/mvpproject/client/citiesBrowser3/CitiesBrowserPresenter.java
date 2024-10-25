package com.fkereki.mvpproject.client.citiesBrowser3;

import java.util.Iterator;
import java.util.LinkedHashMap;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.countryState.CountryStatePresenter;
import com.fkereki.mvpproject.client.rpc.ClientCityData;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;

public class CitiesBrowserPresenter
    extends Presenter<CitiesBrowserDisplay> {
  public static String PLACE = "citybrowse";

  /*
   * This implements the "Command" pattern: the cities display will be parceled
   * into several short, spaced, processes, so the end user will feel the
   * browser to "more responsive"...
   */
  private class TimedCitiesDisplay
      extends Timer {

    final NumberFormat nf = NumberFormat.getDecimalFormat();
    LinkedHashMap<String, ClientCityData> citiesList = null;
    Iterator<String> currentCity = null;
    int currentRow = 0;

    String originalCountry = null;
    String originalState = null;
    int originalStart = 0;

    public TimedCitiesDisplay(
        final LinkedHashMap<String, ClientCityData> pCitiesList) {
      citiesList = pCitiesList;
      currentCity = pCitiesList.keySet().iterator();
      currentRow = 0;

      /*
       * Save the current country, region, and start, so in case the user
       * changes to a different page, the run() method won't display anything
       * and won't schedule new timers either.
       */
      originalCountry = getDisplay().getCountryState().getCountry();
      originalState = getDisplay().getCountryState().getState();
      originalStart = currentStart;

      /*
       * Start by displaying a "Loading..." message, before the actual run.
       */
      displayEmptyCities(0, "Loading...");
    }

    @Override
    public void run() {
      /*
       * Display a few cities; if there are any remaining, schedule a new
       * process. If there was any change (different country, region, or start)
       * don't do anything.
       */
      boolean someMore = originalCountry.equals(getDisplay()
          .getCountryState().getCountry())
          && originalState.equals(getDisplay().getCountryState()
              .getState()) // 
          && originalStart == currentStart;

      for (int i = 0; someMore && i < CITIES_AT_A_TIME; i++) {
        if (currentCity.hasNext()) {
          final ClientCityData cd = citiesList.get(currentCity.next());
          currentRow++;
          getDisplay().setCityData(currentRow, cd.cityName,
              nf.format(cd.population), nf.format(cd.latitude),
              nf.format(cd.longitude));
        } else {
          /*
           * If there are no more cities, display empty lines (a fast process)
           * and disable the next timer call
           */
          displayEmptyCities(currentRow, "");
          someMore = false;
        }
      }

      /*
       * If there are still some more cities to display, schedule a new display
       * process in a short while.
       */
      if (someMore) {
        schedule(CITIES_DELAY_IN_MS);
      }
    }
  }

  static final int CITIES_AT_A_TIME = 10;
  static final int CITIES_DELAY_IN_MS = 4250;

  int currentStart = 0;

  CountryStatePresenter csp;

  public CitiesBrowserPresenter(
      final String params,
      final CitiesBrowserDisplay citiesBrowserDisplay,
      final Environment environment) {

    super(params, citiesBrowserDisplay, environment);

    csp = new CountryStatePresenter("", getDisplay().getCountryState(),
        environment);

    clearCities();

    getDisplay().setOnFirstClickCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(final Object result) {
        if (checkCountryAndState()) {
          currentStart = 0;
          getAndDisplayCities();
        }
      }
    });

    getDisplay().setOnPreviousClickCallback(
        new SimpleCallback<Object>() {
          @Override
          public void goBack(final Object result) {
            if (checkCountryAndState()) {
              currentStart -= CitiesBrowserView.CITIES_PAGE_SIZE;
              getAndDisplayCities();
            }
          }
        });

    getDisplay().setOnNextClickCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(final Object result) {
        if (checkCountryAndState()) {
          currentStart += CitiesBrowserView.CITIES_PAGE_SIZE;
          getAndDisplayCities();
        }
      }
    });

    getDisplay().setOnCountryStateChangeCallback(
        new SimpleCallback<Object>() {
          @Override
          public void goBack(final Object result) {
            clearCities();
          }
        });
  }

  boolean checkCountryAndState() {
    return !getDisplay().getCountryState().getCountry().isEmpty()
        && !getDisplay().getCountryState().getState().isEmpty();
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
    getEnvironment().getModel().getCities(
        getDisplay().getCountryState().getCountry(),
        getDisplay().getCountryState().getState(), currentStart,
        CitiesBrowserView.CITIES_PAGE_SIZE,
        new SimpleCallback<LinkedHashMap<String, ClientCityData>>() {
          @Override
          public void goBack(
              final LinkedHashMap<String, ClientCityData> result) {

            new TimedCitiesDisplay(result).run();
          }
        });

  }
}