package com.fkereki.mvpproject.client.rpc;

import java.util.LinkedHashMap;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface WorldServiceAsync {

  void addCity(ClientCityData cd, AsyncCallback<String> callback);

  void cityExists(
      String pCountry,
      String pRegion,
      String pCity,
      AsyncCallback<Boolean> callback);

  void getCities(
      String pCountry,
      String pRegion,
      int pFrom,
      int pQuantity,
      AsyncCallback<LinkedHashMap<String, ClientCityData>> callback);

  void getCitiesStartingWith(
      String pCountry,
      String pRegion,
      String pStart,
      AsyncCallback<LinkedHashMap<String, ClientCityData>> callback);

  void getCountries(
      AsyncCallback<LinkedHashMap<String, String>> callback);

  void getStates(
      String pCountry,
      AsyncCallback<LinkedHashMap<String, String>> callback);
}