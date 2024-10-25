package com.fkereki.mvpproject.client;

import java.util.LinkedHashMap;

import com.fkereki.mvpproject.client.rpc.ClientCityData;
import com.fkereki.mvpproject.client.rpc.LoginService;
import com.fkereki.mvpproject.client.rpc.LoginServiceAsync;
import com.fkereki.mvpproject.client.rpc.WorldService;
import com.fkereki.mvpproject.client.rpc.WorldServiceAsync;
import com.fkereki.mvpproject.client.rpc.XhrProxy;
import com.fkereki.mvpproject.client.rpc.XhrProxyAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author fkereki
 */
public class Model {
  private LoginServiceAsync loginService;
  private WorldServiceAsync worldService;
  private XhrProxyAsync xhrProxy;

  public void getCities_nocache(
      final String country,
      final String state,
      final int pStart,
      final int pCount,
      final AsyncCallback<LinkedHashMap<String, ClientCityData>> cb) {
    /*
     * If we call "loadCities(...)" without having selected a country and
     * region, it won't do anything, and just exit gracefully.
     */
    if (!country.isEmpty() && !state.isEmpty()) {
      getRemoteWorldService().getCities(country, state, pStart, pCount,
          new AsyncCallback<LinkedHashMap<String, ClientCityData>>() {
            public void onFailure(final Throwable caught) {
              Window.alert("Failure getting cities: "
                  + caught.getMessage());
            }

            public void onSuccess(
                final LinkedHashMap<String, ClientCityData> result) {
              cb.onSuccess(result);
            }
          });
    }
  }

  /*
   * The cache key is COUNTRY:REGION:STARTING_CITY_NUMBER and the associated
   * value is a LinkedHashMap<String,ClientCityData>
   */
  static LinkedHashMap<String, LinkedHashMap<String, ClientCityData>> citiesCache = new LinkedHashMap<String, LinkedHashMap<String, ClientCityData>>();

  public void getCities_withCache_withoutPrefetching(
      final String country,
      final String state,
      final int pStart,
      final int pCount,
      final AsyncCallback<LinkedHashMap<String, ClientCityData>> cb) {
    /*
     * If we call "loadCities(...)" without having selected a country and
     * region, it won't do anything, and just exit gracefully.
     */
    if (!country.isEmpty() && !state.isEmpty()) {

      if (!citiesCache
          .containsKey(country + ":" + state + ":" + pStart)) {
        getRemoteWorldService().getCities(country, state, pStart,
            pCount,
            new AsyncCallback<LinkedHashMap<String, ClientCityData>>() {
              public void onFailure(final Throwable caught) {
                Window.alert("Failure getting cities: "
                    + caught.getMessage());
              }

              public void onSuccess(
                  final LinkedHashMap<String, ClientCityData> result) {

                citiesCache.put(country + ":" + state + ":" + pStart,
                    result);
                cb.onSuccess(result);
              }
            });
      } else {
        /*
         * Data were already loaded, so just display them
         */
        cb.onSuccess(citiesCache.get(country + ":" + state + ":"
            + pStart));

      }
    }
  }

  public void getCities(
      final String country,
      final String state,
      final int pStart,
      final int pCount,
      final AsyncCallback<LinkedHashMap<String, ClientCityData>> cb) {

    if (!country.isEmpty() && !state.isEmpty()) {

      if (!citiesCache.containsKey(country + ":" + state + ":"
          + (pStart + pCount))) {

        getRemoteWorldService().getCities(country, state,
            pStart + pCount, pCount,
            new AsyncCallback<LinkedHashMap<String, ClientCityData>>() {
              public void onFailure(final Throwable caught) {
                // ...error...
              }

              public void onSuccess(
                  final LinkedHashMap<String, ClientCityData> result) {

                citiesCache.put(country + ":" + state + ":"
                    + (pStart + pCount), result);
              }
            });
      }

      if (!citiesCache
          .containsKey(country + ":" + state + ":" + pStart)) {

        getRemoteWorldService().getCities(country, state, pStart,
            pCount,
            new AsyncCallback<LinkedHashMap<String, ClientCityData>>() {
              public void onFailure(final Throwable caught) {
                // ...error...
              }

              public void onSuccess(
                  final LinkedHashMap<String, ClientCityData> result) {

                citiesCache.put(country + ":" + state + ":" + pStart,
                    result);
                cb.onSuccess(result);
              }
            });

      } else {
        cb.onSuccess(citiesCache.get(country + ":" + state + ":"
            + pStart));

      }
    }
  }

  public void getCountries_nocache(
      final AsyncCallback<LinkedHashMap<String, String>> cb) {
    getRemoteWorldService().getCountries(
        new AsyncCallback<LinkedHashMap<String, String>>() {
          @Override
          public void onFailure(final Throwable caught) {
            Window.alert("Failure getting cities: "
                + caught.getMessage());
          }

          @Override
          public void onSuccess(
              final LinkedHashMap<String, String> result) {
            cb.onSuccess(result);
          }
        });
  }

  static LinkedHashMap<String, String> countriesCache = null;

  public void getCountries(
      final AsyncCallback<LinkedHashMap<String, String>> cb) {

    if (countriesCache == null) {
      getRemoteWorldService().getCountries(
          new AsyncCallback<LinkedHashMap<String, String>>() {
            @Override
            public void onFailure(final Throwable caught) {
              Window.alert("Failure getting cities: "
                  + caught.getMessage());
            }

            @Override
            public void onSuccess(
                final LinkedHashMap<String, String> result) {

              countriesCache = result;
              cb.onSuccess(result);
            }
          });
    } else {
      cb.onSuccess(countriesCache);
    }
  }

  /**
   * Provide a remote login service handle; Use lazy evaluation for extra speed.
   * 
   * @return
   */
  public LoginServiceAsync getRemoteLoginService() {
    if (loginService == null) {
      loginService = GWT.create(LoginService.class);
    }
    return loginService;
  }

  /**
   * Provide a remote world service handle; Use lazy evaluation for extra speed.
   * 
   * @return
   */
  public WorldServiceAsync getRemoteWorldService() {
    if (worldService == null) {
      worldService = GWT.create(WorldService.class);
    }
    return worldService;
  }

  /**
   * Provide a remote XHR proxy handle; Use lazy evaluation for extra speed.
   * 
   * @return
   */
  public XhrProxyAsync getRemoteXhrProxy() {
    if (xhrProxy == null) {
      xhrProxy = GWT.create(XhrProxy.class);
    }
    return xhrProxy;
  }

  public void getStates_nocache(
      final String country,
      final AsyncCallback<LinkedHashMap<String, String>> cb) {

    getRemoteWorldService().getStates(country,
        new AsyncCallback<LinkedHashMap<String, String>>() {
          @Override
          public void onFailure(final Throwable caught) {
            // ...failure...
          }

          @Override
          public void onSuccess(
              final LinkedHashMap<String, String> result) {
            cb.onSuccess(result);
          }
        });
  }

  static LinkedHashMap<String, LinkedHashMap<String, String>> statesCache = new LinkedHashMap<String, LinkedHashMap<String, String>>();

  public void getStates(
      final String country,
      final AsyncCallback<LinkedHashMap<String, String>> cb) {

    if (!statesCache.containsKey(country)) {
      getRemoteWorldService().getStates(country,
          new AsyncCallback<LinkedHashMap<String, String>>() {
            @Override
            public void onFailure(final Throwable caught) {
              // ...failure...
            }

            @Override
            public void onSuccess(
                final LinkedHashMap<String, String> result) {

              statesCache.put(country, result);
              cb.onSuccess(result);
            }
          });
    } else {
      cb.onSuccess(statesCache.get(country));
    }
  }
}