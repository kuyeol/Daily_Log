package com.fkereki.mvpproject.client.cityCreator;

import com.fkereki.mvpproject.client.Display;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.countryState.CountryStateDisplay;

public interface CityCreatorDisplay
    extends Display {

  String getAccentedCityName();

  String getCityName();

  CountryStateDisplay getCountryState();

  float getLatitude();

  float getLongitude();

  int getPopulation();

  void setCityNameCssStyle(String css);

  void setOnAddClickCallback(SimpleCallback<Object> acb);

  void setOnCityNameChangeCallback(SimpleCallback<Object> acb);

  void setOnCountryStateChangeCallback(SimpleCallback<Object> acb);
}
