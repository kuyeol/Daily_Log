package com.fkereki.mvpproject.client.rpc;

import java.util.LinkedHashMap;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("world")
public interface WorldService
    extends RemoteService {
  public String addCity(ClientCityData cd);

  public Boolean cityExists(
      String pCountry,
      String pRegion,
      String pCity);

  public LinkedHashMap<String, ClientCityData> getCities(
      String pCountry,
      String pRegion,
      int pFrom,
      int pQuantity);

  public LinkedHashMap<String, ClientCityData> getCitiesStartingWith(
      String pCountry,
      String pRegion,
      String pStart);

  public LinkedHashMap<String, String> getCountries();

  public LinkedHashMap<String, String> getStates(String pCountry);
}
