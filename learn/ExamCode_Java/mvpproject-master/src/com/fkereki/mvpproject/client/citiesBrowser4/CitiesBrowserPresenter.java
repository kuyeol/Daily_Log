package com.fkereki.mvpproject.client.citiesBrowser4;

import java.util.Iterator;
import java.util.LinkedHashMap;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.countryState.CountryStatePresenter;
import com.fkereki.mvpproject.client.rpc.ClientCityData;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.IncrementalCommand;

public class CitiesBrowserPresenter
    extends Presenter<CitiesBrowserDisplay> {
  public static String PLACE = "citybrowse";

  private class DeferredCitiesDisplay
      implements IncrementalCommand {
    final NumberFormat nf = NumberFormat.getDecimalFormat();
    LinkedHashMap<String, ClientCityData> citiesList = null;
    Iterator<String> currentCity = null;
    int currentRow = 0;

    String originalCountry = null;
    String originalState = null;
    int originalStart = 0;

    public DeferredCitiesDisplay(
        final LinkedHashMap<String, ClientCityData> pCitiesList) {

      citiesList = pCitiesList;
      currentCity = pCitiesList.keySet().iterator();
      currentRow = 0;

      /*
       * Save the current country, region, and start, so in case the user
       * changes to a different page, the execute() method won't do anything,
       * and will stop future runs.
       */
      originalCountry = getDisplay().getCountryState().getCountry();
      originalState = getDisplay().getCountryState().getState();
      originalStart = currentStart;

      /*
       * Start by displaying a "Loading..." message, before the actual run.
       */
      displayEmptyCities(0, "Loading...");
    }

    public boolean execute() {
      /*
       * Display a few cities; if there are any remaining, return true, so the
       * deferred command will execute again. If there was any change (different
       * country, region, or start) don't do anything.
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
           * No more cities; blank the rest of the grid, and set things up so
           * the command won't get executed again.
           */
          displayEmptyCities(currentRow, "");
          someMore = false;
        }
      }

      /*
       * If there are still some more cities to display, return true, so the
       * deferred command will soon execute again; otherwise, return false, and
       * the command won't get executed again.
       */
      return someMore;
    }
  }

  static final int CITIES_AT_A_TIME = 10;

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

            /*
             * Run, as soon as possible, a routine that will display the cities
             * a few at a time.
             */
            DeferredCommand
                .addCommand(new DeferredCitiesDisplay(result));
          }
        });

  }
}